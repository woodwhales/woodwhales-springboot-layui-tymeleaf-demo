package org.woodwhales.layui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 父页面与子页面数据交互
 */
@Controller
public class UserAddDemoController {

	@GetMapping("/userList")
	public String listUser() {
		return "/user-list";
	}
	
	@GetMapping("/userAdd")
	public String addUser() {
		return "/user-add";
	}
}
