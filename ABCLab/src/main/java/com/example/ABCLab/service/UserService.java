package com.example.ABCLab.service;

import java.util.List;

import com.example.ABCLab.dto.UserDto;
import com.example.ABCLab.model.User;

public interface UserService {
	
	User save (UserDto userDto);
	 List<User> getAllUsers();
	 void deleteUser(Long userId);
	 long getTotalUsers();


}
