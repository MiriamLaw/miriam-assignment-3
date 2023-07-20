package com.coderscampus.assignment3;

import java.util.Scanner;

//to validate, to read data from file and create user array

public class UserService {

	private User[] users = new User[4];

	public UserService() {
		loadUsers();
	}

	private void loadUsers() {
		FileService fileService = new FileService();
		users = fileService.readDataFromFile();
	}

//	refactored into method 
	public User getUserByUsernameAndPassword(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public boolean initiateLogin() {

//		let users login up to 5 incorrect attempts
//		for each attempt:
//		-get username and password
//		-validate if user exists with given username and password
//		-if user exists, login valid, show welcome message
//		-else (no user exists), login is invalid, increast attempt counter for next iteration

		try (Scanner scanner = new Scanner(System.in)) {
			int invalidAttempts = 0;

			User loggedInUser = null;
			while (invalidAttempts < 5) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();

				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				loggedInUser = getUserByUsernameAndPassword(username, password);

				if (loggedInUser != null) {
					System.out.println("Welcome " + loggedInUser.getName());
					return true;
				} else {
					System.out.println("Invalid login, please try again.");
					invalidAttempts++;
				}
			}
		}
		return false;
	}
}
//
//	public String[] parseText(String userInfo) {
//		return userInfo.split(",");
//
//	}
//
//	public boolean validateLogin(String username, String password) {
//		Scanner scanner = new Scanner(System.in);
//		int invalidAttempts = 0;
//		boolean loggedIn = false;
//
//		try {
//			while (!loggedIn && invalidAttempts < 5) {
//				for (User user : users) {
//					if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
//						System.out.println("Welcome " + user.getName());
//						loggedIn = true;
//						break;
//					}
//				}
//
//				if (!loggedIn) {
//					invalidAttempts++;
//					System.out.println("Invalid login, please try again.");
//
//					if (invalidAttempts >= 5) {
//						System.out.println("Too many failed login attempts, you are now locked out.");
//						return false;
//					}
//
//					System.out.println("Enter your username: ");
//					username = scanner.nextLine();
//
//					System.out.println("Enter your password: ");
//					password = scanner.nextLine();
//
//				}
//			}
//		} finally {
//			scanner.close();
//		}
//		return loggedIn;
//	}
//}
