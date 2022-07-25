package com.web.dashboard.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dashboard.config.AppBeans;
import com.web.dashboard.entity.Role;
import com.web.dashboard.service.RoleService;
import com.web.dashboard.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/role")
public class RoleController {
		
	@GetMapping("/all")
	public String rolePage(Model model) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			model.addAttribute("roles", roleService.readAll());
			model.addAttribute("role", new Role());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "./role/role";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRole(@PathVariable int id) {		
		Role role = new Role();
		role.setId(id);
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			roleService.delete(role);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/role/all";		
	}
	
	@PostMapping("/create")
	public String createRole(@Validated @ModelAttribute("role") Role role, BindingResult result) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			roleService.create(role);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/role/all";
	}
	
	@GetMapping("/update/{id}")
	public String updateRolePage(@PathVariable int id, Model model) {				
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);

			model.addAttribute("role", roleService.readById(id));

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "./role/update";		
	}
	
	@PostMapping("/update")
	public String updateRole(@Validated @ModelAttribute("role") Role role, BindingResult result) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			roleService.update(role);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/role/all";
	}
	
}
