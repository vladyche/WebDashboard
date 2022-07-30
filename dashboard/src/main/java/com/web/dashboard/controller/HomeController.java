package com.web.dashboard.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		
		return "./home/home";
	}
}
