package com.coderscampus.assignment3;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		boolean loginSuccessful = userService.initiateLogin();

		if (!loginSuccessful) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
	}
}