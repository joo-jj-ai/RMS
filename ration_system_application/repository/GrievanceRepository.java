package com.example.ration_system_application.ration_system_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ration_system_application.ration_system_application.entity.Grievance;
import com.example.ration_system_application.ration_system_application.entity.User;

@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {
    List<Grievance> findByUser(User user);
}

