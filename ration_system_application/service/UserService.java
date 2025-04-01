package com.example.ration_system_application.ration_system_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ration_system_application.ration_system_application.entity.User;
import com.example.ration_system_application.ration_system_application.repository.UserRepository;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByRationCard(String rationCardNumber) {
        return userRepository.findByRationCardNumber(rationCardNumber).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deactivateUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus("DEACTIVATED");
        userRepository.save(user);
    }
}

