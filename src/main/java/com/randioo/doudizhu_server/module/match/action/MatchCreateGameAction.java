package com.randioo.doudizhu_server.module.match.action;

import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.protobuf.GeneratedMessage;
import com.randioo.doudizhu_server.entity.bo.Role;
import com.randioo.doudizhu_server.module.match.service.MatchService;
import com.randioo.doudizhu_server.protocol.Match.MatchCreateGameRequest;
import com.randioo.doudizhu_server.util.SessionUtils;
import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.IActionSupport;

@Controller
@PTAnnotation(MatchCreateGameRequest.class)
public class MatchCreateGameAction implements IActionSupport {

	@Autowired
	private MatchService matchService;

	@Override
	public void execute(Object data, IoSession session) {
		MatchCreateGameRequest request = (MatchCreateGameRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		GeneratedMessage sc = matchService.createRoom(role, request.getGameConfig());
		SessionUtils.sc(session, sc);
	}

}
