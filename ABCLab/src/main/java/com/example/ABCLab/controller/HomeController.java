package com.example.ABCLab.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.userdetails.UserDetailsService;


@Controller
public class HomeController {
    	@Autowired
	UserDetailsService userDetailsService; 

    @GetMapping("/home")
	public String home(Model model, Principal principal) {
			   if (principal != null) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
    }
		return "home";
	}
	@GetMapping("/")
	public String homereturn(Model model, Principal principal) {
			   if (principal != null) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
    }
		return "home";
	}
}
