package org.woodwhales.layui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xadmin")
public class XAdminController {

	@GetMapping({"/index.html", "/"})
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/index";
	}
	
	@GetMapping("welcome.html")
	public String welcome(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/welcome";
	}
	
	@GetMapping("welcome1.html")
	public String welcome1(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/welcome1";
	}

	@GetMapping("admin-add.html")
	public String adminAdd(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/admin-add";
	}

	@GetMapping("admin-edit.html")
	public String adminEdit(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/admin-edit";
	}
	
	@GetMapping("admin-list.html")
	public String adminList(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/admin-list";
	}

	@GetMapping("admin-role.html")
	public String adminRole(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/admin-role";
	}
	
	@GetMapping("role-add.html")
	public String roleAdd(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/role-add";
	}
	
	@GetMapping("admin-batch-add.html")
	public String roleBatchAdd(HttpServletRequest request, HttpServletResponse response) {
		return "xadmin/admin-batch-add";
	}
}
