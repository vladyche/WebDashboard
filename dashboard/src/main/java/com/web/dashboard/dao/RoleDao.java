package com.web.dashboard.dao;

import com.web.dashboard.entity.Role;

public interface RoleDao {
	Role findById(int id);
	Role save(Role role);
	Role update(Role role);
	void delete(Role role);
}
