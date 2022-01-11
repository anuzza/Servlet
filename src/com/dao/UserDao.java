package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	void signup(User u);
	boolean login (String un, String psw);
	List<User> getalluser ();
	

}
