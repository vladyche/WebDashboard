package com.web.dashboard.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dashboard.config.beans.AppBeans;
import com.web.dashboard.entity.Role;
import com.web.dashboard.entity.User;
import com.web.dashboard.service.RoleService;
import com.web.dashboard.service.UserService;
import com.web.dashboard.service.UserStatusList;
import com.web.dashboard.service.impl.RoleServiceImpl;
import com.web.dashboard.service.impl.UserServiceImpl;
import com.web.dashboard.service.impl.UserStatusListImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("")
	public String userRootPath() {
		return "redirect:user/all";
	}
	
	@GetMapping("/all")
	public String usersPage(Model model) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			model.addAttribute("usersActive", userService.readAllActive());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);

			model.addAttribute("usersInactive", userService.readAllInactive());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("user", new User());
		
		return "./user/users";
	}
	
	@GetMapping("/{id}")
	public String userPage(@PathVariable("id") long id, 
			               Model model) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			model.addAttribute("user", userService.readById(id));
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "./user/user-page";
	}
	
	@GetMapping("/create")
	public String userCreatePage(Model model) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			model.addAttribute("roles", roleService.readAll());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("user", new User());
		
		return "./user/user-create";
	}
	
	@PostMapping("/create")
	public String userCreate(@RequestParam int roleId,
							 @ModelAttribute("user") User user, 
							 BindingResult result) {
		Role role = new Role();
		role.setId(roleId);
		
		user.setRole(role);
		user.setStatus(true);
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			userService.create(user);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/all";
	}
	
	@GetMapping("/update/{id}")
	public String userUpdatePage(@PathVariable("id") long id, 
			                     Model model) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			model.addAttribute("user", userService.readById(id));
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
			
			model.addAttribute("roles", roleService.readAll());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserStatusList userStatusList = context.getBean("userStatusList", UserStatusListImpl.class);
			
			model.addAttribute("statuses", userStatusList.list());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "./user/user-update";
	}
	
	@PostMapping("/update")
	public String updateUser(@RequestParam int roleId, 
							 @RequestParam boolean statusId,
			                 @ModelAttribute("user") User user,
			                 BindingResult result) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			Role role = new Role();
			role.setId(roleId);
			
			user.setRole(role);
			user.setStatus(statusId);
			
			userService.update(user);
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/all";
	}
	
	@GetMapping("/delete/mark/{id}")
	public String markForDelete(@PathVariable("id") long id) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			userService.markForDelete(id);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/all";
	}
	
	@GetMapping("/delete/completely/{id}")
	public String deleteCompletely(@PathVariable("id") long id) {
		User user = new User();
		user.setId(id);
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class)) {
			UserService userService = context.getBean("userService", UserServiceImpl.class);
			
			userService.deleteCompletely(user);

		} catch (BeansException e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/all";
	}
	
}
