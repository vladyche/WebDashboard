package com.web.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.web.dashboard.entity.UserStatus;
import com.web.dashboard.service.UserStatusList;

public class UserStatusListImpl implements UserStatusList {

	@Override
	public List<UserStatus> list() { 
		ArrayList<UserStatus> list = new ArrayList<UserStatus>();
		
		UserStatus trueStatus = new UserStatus();
		trueStatus.setId(1);
		trueStatus.setStatus(true);
		trueStatus.setName("Active");
		
		UserStatus falseStatus = new UserStatus();
		falseStatus.setId(2);
		falseStatus.setStatus(false);
		falseStatus.setName("Deleted");
		
		list.add(trueStatus);
		list.add(falseStatus);
		
		return list;
	}

}
