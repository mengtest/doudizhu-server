package com.randioo.doudizhu_server.module.role.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.doudizhu_server.entity.bo.Role;
import com.randioo.randioo_server_base.utils.service.ObserveBaseServiceInterface;

public interface RoleService extends ObserveBaseServiceInterface {

	void newRoleInit(Role role);

	public void roleInit(Role role);

	GeneratedMessage rename(Role role, String name);

}
