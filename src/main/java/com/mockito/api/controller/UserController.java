package com.mockito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.api.model.User;
import com.mockito.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);

	}

	@GetMapping(value = "/getUsers")
	public List<User> findAllUsers() {
		return userService.getUsers();
	}

}
