package com.web.dashboard.service.impl;

import java.util.List;

import com.web.dashboard.dao.UserDao;
import com.web.dashboard.entity.User;
import com.web.dashboard.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserServiceImpl() {}

	@Override
	public User create(User user) {
		return userDao.save(user);
	}

	@Override
	public User readById(long id) {
		return userDao.findById(id);
	}

	@Override
	public User readByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> readAll() {
		return userDao.findAll();
	}

	@Override
	public void deleteCompletely(User user) {
		userDao.deleteCompletely(user);
	}

	@Override
	public void markForDelete(long id) {
		userDao.markForDelete(id);
	}
	
}
