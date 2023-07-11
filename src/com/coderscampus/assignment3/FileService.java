package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readDataFromFile() {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))) {
			User[] users = new User[4];
			String line;
			int count = 0;
			while ((line = fileReader.readLine()) != null) {
				
				String[] userInfo = line.split(",");

				String username = userInfo[0];
				String password = userInfo[1];
				String name = userInfo[2];

				User user = new User(username, password, name);

				users[count] = user;
				count++;

			}
			return users;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
