package com.example.ration_system_application.ration_system_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ration_system_application.ration_system_application.entity.Grievance;
import com.example.ration_system_application.ration_system_application.service.GrievanceService;

@CrossOrigin
@RestController
@RequestMapping("/grievances")
public class GrievanceController {
    @Autowired
    private GrievanceService grievanceService;

    @PostMapping("/create")
    public Grievance createGrievance(@RequestBody Grievance grievance) {
        return grievanceService.createGrievance(grievance);
    }

    @PutMapping("/resolve/{grievanceId}")
    public Grievance resolveGrievance(@PathVariable Long grievanceId, @RequestParam String response) {
        return grievanceService.resolveGrievance(grievanceId, response);
    }
}

