package com.web.dashboard.service.impl;

import java.util.List;

import com.web.dashboard.dao.RoleDao;
import com.web.dashboard.entity.Role;
import com.web.dashboard.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao roleDao;
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public RoleServiceImpl() {}

	@Override
	public Role create(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role readById(int id) {
		return roleDao.findById(id);
	}
	
	@Override
	public List<Role> readAll() {
		return roleDao.findAll();
	}

	@Override
	public Role update(Role role) {
		return roleDao.update(role);
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}
	
}
