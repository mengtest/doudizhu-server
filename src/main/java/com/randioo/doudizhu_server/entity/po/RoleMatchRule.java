package com.randioo.doudizhu_server.entity.po;

import com.randioo.randioo_server_base.module.match.MatchRule;

public class RoleMatchRule extends MatchRule implements Comparable<RoleMatchRule> {
	private int roleId;
	private int matchTime;
	private boolean ai;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean isAi() {
		return ai;
	}

	public void setAi(boolean ai) {
		this.ai = ai;
	}

	public void setMatchTime(int matchTime) {
		this.matchTime = matchTime;
	}

	@Override
	public int compareTo(RoleMatchRule o) {
		return matchTime - o.matchTime;
	}

}
