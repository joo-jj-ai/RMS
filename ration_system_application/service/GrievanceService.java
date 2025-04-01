package com.example.ration_system_application.ration_system_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ration_system_application.ration_system_application.entity.Grievance;
import com.example.ration_system_application.ration_system_application.entity.User;
import com.example.ration_system_application.ration_system_application.repository.GrievanceRepository;

@Service
public class GrievanceService {
    @Autowired
    private GrievanceRepository grievanceRepository;

    public Grievance createGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    public List<Grievance> getUserGrievances(User user) {
        return grievanceRepository.findByUser(user);
    }

    public Grievance resolveGrievance(Long grievanceId, String response) {
        Grievance grievance = grievanceRepository.findById(grievanceId).orElseThrow(() -> new RuntimeException("Grievance not found"));
        grievance.setStatus("CLOSED");
        grievance.setResponse(response);
        return grievanceRepository.save(grievance);
    }
}

