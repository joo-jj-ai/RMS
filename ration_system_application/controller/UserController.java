package com.example.ration_system_application.ration_system_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ration_system_application.ration_system_application.entity.User;
import com.example.ration_system_application.ration_system_application.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{rationCardNumber}")
    public User getUser(@PathVariable String rationCardNumber) {
        return userService.getUserByRationCard(rationCardNumber);
    }

    @PutMapping("/deactivate/{userId}")
    public void deactivateUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
    }
}

