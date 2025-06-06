package com.example.ration_system_application.ration_system_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ration_system_application.ration_system_application.entity.User;

@Repository
	public interface UserRepository extends JpaRepository<User, Long> {
	    Optional<User> findByRationCardNumber(String rationCardNumber);
	}


