package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//to validate, to read data from file and create user array

public class UserService {

	private User[] users = new User[4];

	public User[] createUserArray(String username, String password, String name) {
		users = new User[4];

		for (int i = 0; i < 4; i++) {
			User user = new User(username, password, name);
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			users[i] = user;

		}
		return users;
	}

	public String[] parseText(String userInfo) {
		return userInfo.split(",");

	}

	public void readDataFromFile() {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))) {
			String line;
			int count = 0;
			while ((line = fileReader.readLine()) != null) {
				// process each line of the file
				String[] userInfo = line.split(",");

				String username = userInfo[0];
				String password = userInfo[1];
				String name = userInfo[2];

				User user = new User(username, password, name);

				users[count] = user;
				count++;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean validateLogin(String username, String password, String name) {
		Scanner scanner = new Scanner(System.in);
		int invalidAttempts = 0;
		boolean loggedIn = false;

		try {
			while (!loggedIn && invalidAttempts < 5) {
				for (User user : users) {
					if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
						System.out.println("Welcome " + user.getName());
						loggedIn = true;
						break;
					}
				}

				if (!loggedIn) {
					invalidAttempts++;
					System.out.println("Invalid login, please try again.");

					if (invalidAttempts >= 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						return false;
					}

					System.out.println("Enter your username: ");
					username = scanner.nextLine();

					System.out.println("Enter your password: ");
					password = scanner.nextLine();

				}
			}
		} finally {
			scanner.close();
		}
		return loggedIn;
	}
}
