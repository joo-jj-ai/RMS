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

import com.example.ration_system_application.ration_system_application.entity.RationRequest;
import com.example.ration_system_application.ration_system_application.service.RationRequestService;

@CrossOrigin
@RestController
@RequestMapping("/requests")

public class RationRequestController {
    @Autowired
    private RationRequestService rationRequestService;

    @PostMapping("/create")
    public RationRequest createRequest(@RequestBody RationRequest rationRequest) {
        return rationRequestService.createRationRequest(rationRequest);
    }

    @PutMapping("/approve/{requestId}")
    public RationRequest approveRequest(@PathVariable Long requestId, @RequestParam String comment) {
        return rationRequestService.approveRequest(requestId, comment);
    }

    @PutMapping("/reject/{requestId}")
    public RationRequest rejectRequest(@PathVariable Long requestId, @RequestParam String comment) {
        return rationRequestService.rejectRequest(requestId, comment);
    }
}

