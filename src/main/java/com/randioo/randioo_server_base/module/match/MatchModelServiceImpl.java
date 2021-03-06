package com.randioo.randioo_server_base.module.match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

import org.springframework.beans.factory.annotation.Autowired;

import com.randioo.randioo_server_base.db.DBRunnable;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.module.match.MatchRule.MatchState;
import com.randioo.randioo_server_base.net.CacheLockUtil;
import com.randioo.randioo_server_base.utils.TimeUtils;
import com.randioo.randioo_server_base.utils.scheduler.EventScheduler;

public class MatchModelServiceImpl extends BaseService implements MatchModelService {

	private ExecutorService executor = null;
	private ExecutorService matchSuccessExecutor = null;

	@Autowired
	private EventScheduler eventScheduler;

	private MatchHandler matchHandler;

	@Override
	public void initService() {
		executor = Executors.newSingleThreadScheduledExecutor();
		matchSuccessExecutor = Executors.newCachedThreadPool();
	}

	@Override
	public void setMatchHandler(MatchHandler matchHandler) {
		this.matchHandler = matchHandler;
	}

	@Override
	public void matchRole(MatchRule matchRule) {
		matchRule.setState(MatchState.MATCH_READY);
		// 添加匹配信息
		MatchRuleCache.getMatchRuleMap().put(matchRule.getId(), matchRule);
		// 设置超时定时器
		executor.submit(new DBRunnable<MatchRule>(matchRule) {

			@Override
			public void run(MatchRule entity) {
				try {
					// 由于异步加入，所以加入之前先检查一次是否可以删除
					Lock lock = getLock(entity.getId());
					try {
						lock.lock();
						if (checkDelete(entity)) {
							return;
						}
					} finally {
						lock.unlock();
					}
					MatchRuleCache.getMatchTempMap().put(entity.getId(), entity);

					Set<String> matchRuleIdSet = new HashSet<>(MatchRuleCache.getMatchRuleMap().keySet());

					boolean matchSuccess = false;
					for (String id : matchRuleIdSet) {
						MatchRule matchRule = MatchRuleCache.getMatchRuleMap().get(id);
						// 不能匹配自己
						if (matchRule.getId().equals(entity.getId())) {
							continue;
						}

						// 先检查规则，通过了在考虑同步问题
						if (!matchHandler.checkMatchRule(entity, matchRule))
							continue;

						// 检查是否要删除,检查第二次,主要还是为了提高锁同步的必要性,由于检查匹配规则的耗时可能非常的长,但是玩家可以随取消匹配的
						// 只检查自己是否取消匹配，如果取消匹配了，则下面的人不可能匹配上，直接下一个人
						if (checkDelete(entity))
							break;

						// 规则匹配没有问题则加入到缓存
						MatchRuleCache.getMatchTempMap().put(matchRule.getId(), matchRule);

						// 匹配到的人的集合与当前人的规则进行比较
						if (!matchHandler.checkArriveMaxCount(entity, MatchRuleCache.getMatchTempMap()))
							continue;

						initLocks();
						try {
							lockSet_Lock();

							for (MatchRule rule : MatchRuleCache.getMatchTempMap().values()) {
								if (checkDelete(rule))
									MatchRuleCache.getNeedDeleteIdTempSet().add(rule.getId());
							}

							// 如果有要删除的则再找下一个人
							if (MatchRuleCache.getNeedDeleteIdTempSet().size() > 0) {
								for (String deleteId : MatchRuleCache.getNeedDeleteIdTempSet())
									MatchRuleCache.getMatchTempMap().remove(deleteId);
								continue;
							}

							// 匹配成功
							for (MatchRule rule : MatchRuleCache.getMatchTempMap().values())
								rule.setState(MatchState.MATCH_SUCCESS);

							matchSuccess = true;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lockSet_Unlock();
							MatchRuleCache.getLocksTempMap().clear();
							MatchRuleCache.getNeedDeleteIdTempSet().clear();
						}
					}
					if (matchSuccess) {
						MatchRuleCache.getDeleteMatchRuleIdSet().addAll(MatchRuleCache.getMatchTempMap().keySet());
						Map<String, MatchRule> copyTempMap = new HashMap<>(MatchRuleCache.getMatchTempMap());
						try {
							matchSuccessExecutor.submit(new DBRunnable<Map<String, MatchRule>>(copyTempMap) {

								@Override
								public void run(Map<String, MatchRule> entity) {
									matchHandler.matchSuccess(entity);
								}

							});
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 删除作废的匹配
					for (String ruleId : MatchRuleCache.getDeleteMatchRuleIdSet())
						MatchRuleCache.getMatchRuleMap().remove(ruleId);

					MatchRuleCache.getMatchTempMap().clear();
					MatchRuleCache.getDeleteMatchRuleIdSet().clear();
				}
			}
		});

		// 如果没有设置等待时间则不进行倒计时
		if (matchRule.getWaitTime() == 0)
			return;

		MatchTimeEvent timeEvent = new MatchTimeEvent(matchRule) {

			@Override
			public void outOfTime(MatchRule matchRule) {
				if (checkDelete(matchRule))
					return;

				Lock lock = getLock(matchRule.getId());
				try {
					lock.lock();
					if (checkDelete(matchRule))
						return;

					matchHandler.outOfTime(matchRule);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		};

		int endTime = TimeUtils.getNowTime() + matchRule.getWaitTime();
		timeEvent.setEndTime(endTime);
		// 发送定时器
		eventScheduler.addEvent(timeEvent);
	}

	/**
	 * 检查是否删除
	 * 
	 * @param matchRule
	 * @return
	 */
	private boolean checkDelete(MatchRule matchRule) {
		if (matchRule == null)
			return true;

		MatchState state = matchRule.getState();
		if (state != MatchState.MATCH_CANCEL && state != MatchState.MATCH_SUCCESS)
			return false;

		MatchRuleCache.getDeleteMatchRuleIdSet().add(matchRule.getId());

		return true;
	}

	@Override
	public void cancelMatch(String ruleId) {
		MatchRule matchRule = MatchRuleCache.getMatchRuleMap().get(ruleId);

		if (checkDelete(matchRule))
			return;
		Lock lock = getLock(ruleId);
		try {
			lock.lock();

			if (checkDelete(matchRule))
				return;

			matchRule.setState(MatchState.MATCH_CANCEL);
		} finally {
			lock.unlock();
		}

	}

	/**
	 * 获得锁
	 * 
	 * @param id
	 * @return
	 * @author wcy 2017年5月26日
	 */
	private Lock getLock(String id) {
		return CacheLockUtil.getLock(MatchRule.class, id);
	}

	private void initLocks() {
		Map<String, MatchRule> map = MatchRuleCache.getMatchTempMap();
		for (MatchRule matchRule : map.values())
			MatchRuleCache.getLocksTempMap().add(getLock(matchRule.getId()));
	}

	private void lockSet_Lock() {
		for (Lock lock : MatchRuleCache.getLocksTempMap())
			lock.lock();

	}

	private void lockSet_Unlock() {
		for (Lock lock : MatchRuleCache.getLocksTempMap()) {
			lock.unlock();
		}
	}

}
