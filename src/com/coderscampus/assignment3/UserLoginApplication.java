package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
		String name = "";

		
		UserService userService = new UserService();
		
		userService.readDataFromFile();
		
		User[] users = userService.createUserArray(username, password, name);
		
		userService.validateLogin(users, username, password);
		
		
		
		
		
		
		

		scanner.close();
	}
		

}

