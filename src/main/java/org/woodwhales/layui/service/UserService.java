package org.woodwhales.layui.service;

import java.util.List;

import org.woodwhales.layui.controller.request.user.UserRequestParams;
import org.woodwhales.layui.entity.User;
import org.woodwhales.layui.service.dto.PageDTO;
import org.woodwhales.layui.service.dto.UserDetailDTO;

public interface UserService {

	PageDTO<UserDetailDTO> list(UserRequestParams requestParams);

	List<User> selectUserListByRoleId(Long roleId);
	
	List<User> selectUserListByRoleCode(String roleCode);
}
