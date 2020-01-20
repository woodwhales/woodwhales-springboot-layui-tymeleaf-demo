package org.woodwhales.layui.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.woodwhales.layui.entity.Role;
import org.woodwhales.layui.repository.RoleRepository;
import org.woodwhales.layui.service.RoleService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role>implements RoleService {

	@Override
	public List<Role> selectRoleListByUserId(Long userId) {
		return baseMapper.selectRoleListByUserId(userId);
	}
	
	@Override
	public List<Role> selectRoleListByUserCode(String userCode) {
		return baseMapper.selectRoleListByUserCode(userCode);
	}
}
