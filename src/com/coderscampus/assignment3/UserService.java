package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;

//to validate, to read data from file and create user array

public class UserService {
	
	public User createUser(String username, String password, String name) {
		User user = new User(username, password, name);
		user.setName(name);
		user.setPassword(password);
		user.setName(name);
		return user;
		
	}
	BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"));

}
