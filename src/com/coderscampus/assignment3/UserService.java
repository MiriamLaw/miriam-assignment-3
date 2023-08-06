package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserService {

	private User[] users = new User[4];

	public UserService() {
		loadUsers();

	}

	private void loadUsers() {
		FileService fileService = new FileService();
		users = fileService.readDataFromFile();
	}

	public User getUserByUsernameAndPassword(String username, String password) {

		for (User user : users) {
			if (user.getName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public boolean initiateLogin() {

		int invalidAttempts = 0;
		User loggedInUser = null;
		try (Scanner scanner = new Scanner(System.in)) {

			while (invalidAttempts < 5) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();

				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				loggedInUser = getUserByUsernameAndPassword(username, password);

				if (loggedInUser != null) {
					System.out.println("Welcome " + loggedInUser.getName());
					return true;
				} else if (loggedInUser == null) {
					System.out.println("Invalid login, please try again.");
					invalidAttempts++;
				}

			}
		}
		if (invalidAttempts >= 5 && loggedInUser != null) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}

		return false;
	}

}
