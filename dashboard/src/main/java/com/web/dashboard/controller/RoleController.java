package com.web.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {
	
	@RequestMapping("/role")
	public String rolePage() {
		return "role";
	}
}
