package com.example.ABCLab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.ABCLab.dto.UserDto;
import com.example.ABCLab.model.User;
import com.example.ABCLab.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}