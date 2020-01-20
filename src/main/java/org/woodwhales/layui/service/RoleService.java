package org.woodwhales.layui.service;

import java.util.List;

import org.woodwhales.layui.entity.Role;

public interface RoleService {

	List<Role> selectRoleListByUserId(Long userId);
	
	List<Role> selectRoleListByUserCode(String userCode);
}
