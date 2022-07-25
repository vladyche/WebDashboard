package com.web.dashboard.service;

import java.util.List;

import com.web.dashboard.entity.Role;

public interface RoleService {
	Role create(Role role);
	Role readById(int id);
	List<Role> readAll();
	Role update(Role role);
	void delete(Role role);
}
