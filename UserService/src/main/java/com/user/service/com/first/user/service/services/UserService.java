package com.user.service.com.first.user.service.services;

import java.util.List;

import com.user.service.com.first.user.service.entities.User;

public interface UserService {

//	User Operations :-)

// Create Users
	User saveUser(User user);
	
//	Get All Users
	List<User> getAllUser();
	
//	Get User By Id
	User getUserById(String id);

}
