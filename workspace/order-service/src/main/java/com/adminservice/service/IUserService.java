package com.adminservice.service;

import java.util.List;
import java.util.Optional;

import com.adminservice.entity.User;

public interface IUserService {

	User saveUser(User user);

	Optional<User> getUserById(int userId);

	List<User> getAllUsers();

    String deleteUser(int userId);

}
