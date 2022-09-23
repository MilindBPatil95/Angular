package com.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.entity.User;
import com.adminservice.exceptionhandler.CustomExceptionHandler;
import com.adminservice.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(int userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new CustomExceptionHandler.UserNotFoundException("USER NOT FOUND"));
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User deleteUser(int userId) {

		User user = getUserById(userId);
		userRepository.deleteById(userId);
		return user;

	}

}
