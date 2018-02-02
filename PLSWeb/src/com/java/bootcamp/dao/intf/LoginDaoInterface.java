package com.java.bootcamp.dao.intf;

import com.java.bootcamp.object.User;

public interface LoginDaoInterface {
	public User retrieveInfo(String username, String password);
}
