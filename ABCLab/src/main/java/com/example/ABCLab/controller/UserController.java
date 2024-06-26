package com.example.ABCLab.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ABCLab.dto.UserDto;
import com.example.ABCLab.model.User;
import com.example.ABCLab.service.UserService;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model,HttpServletRequest request) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!please login ");
		return "redirect:/login"; 
	}
	@PostMapping("/admin/addUser")
	public String addUser(@ModelAttribute("user") UserDto userDto, Model model,HttpServletRequest request) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly");
		return "admin/adduser";

	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);

		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin/admin";
	}

	@GetMapping("/tech/home")
	public String techPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "tech/home";
	}
	@GetMapping("/admin/adduser")
	public String adduserPage (Model model, Principal principal) {
		return "admin/adduser";
	}
	@GetMapping("/admin/users")
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();

        model.addAttribute("users", userList);

        return "admin/userlist";
    }
	    @GetMapping("/admin/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId, Model model) {
        userService.deleteUser(userId);
        model.addAttribute("message", "User deleted successfully");
        return "redirect:/admin/users";
    }
	

}
