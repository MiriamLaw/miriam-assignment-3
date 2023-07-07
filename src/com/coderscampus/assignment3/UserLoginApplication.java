package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		userService.readDataFromFile();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your username: ");
		String username = scanner.nextLine();

		System.out.println("Enter your password: ");
		String password = scanner.nextLine();

		String name = "";

		userService.validateLogin(username, password, name);

		scanner.close();
	}

}
