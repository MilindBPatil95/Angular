package com.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.entity.User;
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
	public Optional<User> getUserById(int userId) {

		return userRepository.findById(userId);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public String deleteUser(int userId) {

		Optional<User> user = getUserById(userId);

		if (user.isEmpty()) {
			return "USER NOT FOUND";
		} else {
			userRepository.deleteById(userId);
			return "USER DELETED SUCCESSFULLY";
		}
	}

}
