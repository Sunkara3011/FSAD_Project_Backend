package com.indianheritage.heritagebackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.indianheritage.heritagebackend.entity.User;
import com.indianheritage.heritagebackend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        if(existing.isPresent()) {
            return "Email already exists";
        }

        if(user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        userRepository.save(user);
        return "Registered Successfully";
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {

        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());

        if(dbUser.isPresent() &&
           dbUser.get().getPassword().equals(user.getPassword())) {

            return dbUser.get();
        }

        return "Invalid Credentials";
    }
}