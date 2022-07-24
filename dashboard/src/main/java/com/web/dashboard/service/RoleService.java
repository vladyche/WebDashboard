package com.web.dashboard.service;

import com.web.dashboard.entity.Role;

public interface RoleService {
	Role create(Role role);
	Role readById(int id);
	Role update(Role role);
	void delete(Role role);
}
