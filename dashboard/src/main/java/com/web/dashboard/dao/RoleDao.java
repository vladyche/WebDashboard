package com.web.dashboard.dao;

import java.util.List;

import com.web.dashboard.entity.Role;

public interface RoleDao {
	Role findById(int id);
	List<Role> findAll();
	Role save(Role role);
	Role update(Role role);
	void delete(Role role);
}
