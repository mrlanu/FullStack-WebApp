package com.lanu.sambamedia;

import com.lanu.sambamedia.entities.User;
import com.lanu.sambamedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SambaMediaApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SambaMediaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User admin = new User("admin@gmail.com","admin","12345");
		userService.createAdmin(admin);
	}
}
