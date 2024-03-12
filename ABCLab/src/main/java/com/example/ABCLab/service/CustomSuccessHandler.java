package com.example.ABCLab.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();

        if (roles.isPresent()) {
            String role = roles.get();
            if (role.equals("ADMIN")) {
                response.sendRedirect("/admin/dashboard");
            } else if (role.equals("USER")) {
                response.sendRedirect("/home");
            
            }
            else if (role.equals("TECHNICIAN")) {
                response.sendRedirect("/tech/dashboard");
            } 
            else {
                response.sendRedirect("/error");
            }
        } else {
            // Handle the case where no roles are present
            response.sendRedirect("/error");
        }
    }
}
