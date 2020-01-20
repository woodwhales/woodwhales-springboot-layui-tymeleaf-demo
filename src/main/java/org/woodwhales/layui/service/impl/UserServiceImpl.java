package org.woodwhales.layui.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woodwhales.layui.controller.request.user.UserRequestParams;
import org.woodwhales.layui.entity.Role;
import org.woodwhales.layui.entity.User;
import org.woodwhales.layui.repository.UserRepository;
import org.woodwhales.layui.service.RoleService;
import org.woodwhales.layui.service.UserService;
import org.woodwhales.layui.service.dto.PageDTO;
import org.woodwhales.layui.service.dto.UserDetailDTO;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public PageDTO<UserDetailDTO> list(UserRequestParams requestParams) {
		Page<User> page = new Page<User>(requestParams.getPage(), requestParams.getLimit());
		LambdaQueryWrapper<User> queryWrapper = null;
		
		Date startTime = requestParams.getStartTime();
		Date endTime = requestParams.getEndTime();
		if(Objects.nonNull(endTime)) {
			endTime = DateUtils.addDays(endTime, 1);
		}
		
		queryWrapper = Wrappers.<User>lambdaQuery().like(StringUtils.isNotBlank(requestParams.getName()), User::getName, requestParams.getName())
												.between(Objects.nonNull(startTime) && Objects.nonNull(endTime), User::getGmtCreated, startTime, endTime)
												.orderByDesc(User::getGmtCreated);
		
		if(Objects.nonNull(startTime) && Objects.isNull(endTime)) {
			queryWrapper.gt(User::getGmtCreated, startTime);
		}
		
		if(Objects.nonNull(endTime) && Objects.isNull(startTime)) {
			queryWrapper.le(User::getGmtCreated, endTime);
		}
		
		IPage<User> pageResult = page(page, queryWrapper);
		
		
		log.debug("pageResult = {}", pageResult.getRecords());
		
		return PageDTO.build(pageResult, pageResult.getRecords()
										.stream()
										.map(user -> toDetailDTO(user, roleService.selectRoleListByUserId(user.getId())))
										.collect(Collectors.toList()));
	}

	@Override
	public List<User> selectUserListByRoleId(Long roleId) {
		return baseMapper.selectUserListByRoleId(roleId);
	}

	@Override
	public List<User> selectUserListByRoleCode(String roleCode) {
		return baseMapper.selectUserListByRoleCode(roleCode);
	}
	
	private UserDetailDTO toDetailDTO(User user, List<Role> roles) {
		UserDetailDTO userDetailDTO = new UserDetailDTO();
		BeanUtils.copyProperties(user, userDetailDTO);
		userDetailDTO.setRoles(roles);
		return userDetailDTO;
	}
}

