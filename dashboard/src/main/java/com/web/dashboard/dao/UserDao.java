package com.web.dashboard.dao;

import java.util.List;

import com.web.dashboard.entity.User;

public interface UserDao {
	User save(User user);
	User findById(long id);
	User findByEmail(String phone);
	User update(User user);
	void deleteCompletely(User user);
	void markForDelete(long id);
	List<User> findAllActive();
	List<User> findAllInactive();
}