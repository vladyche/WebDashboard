package com.web.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage(Model model) {
		model.addAttribute("obj", "Hello ^^");
		return "./home/home";
	}
}
