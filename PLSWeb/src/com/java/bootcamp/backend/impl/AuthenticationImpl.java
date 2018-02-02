package com.java.bootcamp.backend.impl;

import com.java.bootcamp.backend.intf.AuthenticationIntf;
import com.java.bootcamp.dao.impl.LoginDaoImpl;
import com.java.bootcamp.dao.intf.LoginDaoInterface;
import com.java.bootcamp.object.User;

public class AuthenticationImpl implements AuthenticationIntf{

	@Override
	public User login(String username, String password) {

		LoginDaoInterface loginDao = new LoginDaoImpl();
		
		return loginDao.retrieveInfo(username.split("@")[0], password );
	}
}
