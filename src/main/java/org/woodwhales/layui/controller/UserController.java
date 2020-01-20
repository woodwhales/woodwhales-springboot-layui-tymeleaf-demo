package org.woodwhales.layui.controller;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woodwhales.layui.commons.RespResut;
import org.woodwhales.layui.controller.request.user.BatchCreateRequestBody;
import org.woodwhales.layui.controller.request.user.BatchUserInfo;
import org.woodwhales.layui.controller.request.user.UserRequestParams;
import org.woodwhales.layui.controller.vo.PageVO;
import org.woodwhales.layui.controller.vo.RoleTypeVO;
import org.woodwhales.layui.controller.vo.UserInfoDetailVO;
import org.woodwhales.layui.controller.vo.UserInfoVO;
import org.woodwhales.layui.service.UserService;
import org.woodwhales.layui.service.dto.PageDTO;
import org.woodwhales.layui.service.dto.UserDetailDTO;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@PostMapping("batchCreate")
	public Object batchCreate(@RequestBody BatchCreateRequestBody requestBody) {
		
		log.debug("requestBody = {}", requestBody);
		
		List<UserInfoVO> lists =  requestBody.getBatch()
											.stream()
											.map(this::convertTo)
											.collect(Collectors.toList());
		
		return RespResut.success(lists);
	}
	
	@ResponseBody
	@GetMapping("/{userId}")
	public Object queryUserById(@PathVariable("userId") String userId) {
		List<RoleTypeVO> roleTypeList = Lists.newArrayList();
		roleTypeList.add(new RoleTypeVO("01", "普通管理员"));
		roleTypeList.add(new RoleTypeVO("03", "超级管理员"));
		
		return RespResut.success(new UserInfoDetailVO(userId, "user_name_xxx", "1234567890", "xxx@yy.com", roleTypeList));
	}
	
	private UserInfoVO convertTo(BatchUserInfo userInfo) {
		UserInfoVO userInfoVO = new UserInfoVO();
		
		BeanUtils.copyProperties(userInfo, userInfoVO);
		
		if(new Random().nextInt(9) < 6) {
			userInfoVO.setErrorMsg("响应失败");
			userInfoVO.setUserId(null);
		} else {
			userInfoVO.setErrorMsg("响应成功");
			userInfoVO.setUserId(UUID.randomUUID().toString());
		}
		
		return userInfoVO;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Object list(UserRequestParams requestParams) {
		
		log.debug("requestParams = {}", requestParams);
		
		PageDTO<UserDetailDTO> pageDTO = userService.list(requestParams);
		
		return PageVO.build(pageDTO);
	}
}
