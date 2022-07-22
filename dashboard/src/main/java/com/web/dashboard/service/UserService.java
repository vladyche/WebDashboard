package com.web.dashboard.service;

import java.util.List;

import com.web.dashboard.entity.User;

public interface UserService {
	User create(User user);
	User readById(long id);
	User readByEmail(String email);
	User update(User user);
	List<User> readAll();
	void deleteCompletely(User user);
	void markForDelete(long id);	
}
