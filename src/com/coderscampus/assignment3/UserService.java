package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//to validate, to read data from file and create user array

public class UserService {

	public User[] createUserArray(String username, String password, String name) {

		User[] users = new User[4];

		for (int i = 0; i < 4; i++) {
			User user = new User(username, password, name);
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			users[i] = user;

		}

		System.out.println(Arrays.toString(users));
		return users;
	}

	public String[] parseText(String userInfo) {
		return userInfo.split(",");

	}

	public void readDataFromFile() {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))) {
			String line;
			while ((line = fileReader.readLine()) != null) {
				// process each line of the file
				String[] userInfo = line.split(",");

				String username = userInfo[0];
				String password = userInfo[1];
				String name = userInfo[2];

				User user = new User(username, password, name);
				System.out.println(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean validateLogin(User[] users, String username, String password, String name) {
			int loginAttempts = 0;
			
			for (User user : users) {
				if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
					System.out.println("Welcome: " + user.getName(name);
					return true;
				} else {
					loginAttempts++;
				}
				
				if(loginAttempts >=5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					return false;
				} else {
				
				System.out.println("Invalid login, please try again.");
				return false;
	
	

}
}
}
}