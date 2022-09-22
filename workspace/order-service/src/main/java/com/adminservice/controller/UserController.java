package com.adminservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.entity.User;
import com.adminservice.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
	
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("{id}")
	private User getUser(@PathVariable("id") int userId) {
	
		System.out.println("inside:: getUser    "+userId);
		Optional<User> list= userService.getUserById(userId);
        
		return list.get();
	}
	
	@PostMapping("/saveUser")
	private User saveUser(@RequestBody User user) {
		System.out.println(user.toString());
	 return userService.saveUser(user);
	}
	
	@GetMapping("/getAllUsers")
	private List<User> getAllUsers() {
		
	 return userService.getAllUsers();

	}
	
	@DeleteMapping("/deleteUser/{id}")
	private String deleteUser(@PathVariable("id") int userId) {
			System.out.println("inside delete user "+ userId);
	 return	userService.deleteUser(userId);

	}

}
