package org.woodwhales.layui.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woodwhales.layui.commons.RespResut;
import org.woodwhales.layui.controller.vo.RoleTypeVO;
import org.woodwhales.layui.model.RoleType;
import org.woodwhales.layui.service.RoleService;

import com.google.common.collect.Lists;

@Controller
@RequestMapping("/role")
public class RoleTypeController {
	
	@Autowired
	private RoleService roleService;
	
	private static List<RoleType> RoleTypeList = Lists.newArrayList();
	
	static {
		RoleTypeList.add(new RoleType("01", "普通管理员"));
		RoleTypeList.add(new RoleType("02", "系统管理员"));
		RoleTypeList.add(new RoleType("03", "超级管理员"));
	}
	
	@ResponseBody
	@GetMapping("/listAll")
	public Object listAll() {
		
		List<RoleTypeVO> roleTypeVOs = RoleTypeList.stream()
										.map(this::convertFor)
										.collect(Collectors.toList());
		return RespResut.success(roleTypeVOs);
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Object list() {
		return roleService.selectRoleListByUserId(1L);
	}
	
	private RoleTypeVO convertFor(RoleType roleType) {
		RoleTypeVO roleTypeVO = new RoleTypeVO();
		BeanUtils.copyProperties(roleType, roleTypeVO);
		return roleTypeVO;
	}
}
