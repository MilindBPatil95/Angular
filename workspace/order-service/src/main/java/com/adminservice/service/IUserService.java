package com.adminservice.service;

import java.util.List;

import com.adminservice.entity.User;

public interface IUserService {

	User saveUser(User user);

	User getUserById(int userId);

	List<User> getAllUsers();

	User deleteUser(int userId);

}
