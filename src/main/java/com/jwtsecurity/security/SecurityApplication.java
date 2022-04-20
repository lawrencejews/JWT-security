package com.jwtsecurity.security;

import com.jwtsecurity.security.domain.Role;
import com.jwtsecurity.security.domain.User;
import com.jwtsecurity.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null, "Lawrence Lubwama", "lawrence","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Lawrence Jews", "jews","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Lawrence Lauren", "lauren","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Lawrence Lawson", "lawson","1234", new ArrayList<>()));

			userService.addRoleToUser("lawrence", "ROLE_USER");
			userService.addRoleToUser("lawrence", "ROLE_MANAGER");
			userService.addRoleToUser("jews", "ROLE_ADMIN");
			userService.addRoleToUser("lauren", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("lawrence", "ROLE_MANAGER");
		};
	}

}
