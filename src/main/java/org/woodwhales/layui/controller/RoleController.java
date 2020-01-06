package org.woodwhales.layui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@GetMapping("/addUser")
	public String addUser() {
		return "/role-user-manager";
	}

}
