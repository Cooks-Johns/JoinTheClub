package com.example.spring.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.spring.security.model.User;

import com.example.spring.security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
