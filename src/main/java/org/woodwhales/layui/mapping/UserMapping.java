package org.woodwhales.layui.mapping;

import java.util.List;

import org.woodwhales.layui.entity.Role;
import org.woodwhales.layui.entity.User;
import org.woodwhales.layui.service.dto.UserDetailDTO;


public interface UserMapping extends EntityMapper<UserDetailDTO, User>{

	UserDetailDTO toDetailDTO(User user, List<Role> roles);
}

