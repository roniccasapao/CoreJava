package com.java.bootcamp.backend.intf;

import com.java.bootcamp.object.User;

public interface AuthenticationIntf {
	public User login( String username, String password );
}
