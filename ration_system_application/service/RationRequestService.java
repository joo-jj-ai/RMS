package com.example.ration_system_application.ration_system_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ration_system_application.ration_system_application.entity.RationRequest;
import com.example.ration_system_application.ration_system_application.entity.User;
import com.example.ration_system_application.ration_system_application.repository.RationRequestRepository;

@Service
public class RationRequestService {
    @Autowired
    private RationRequestRepository rationRequestRepository;

    public RationRequest createRationRequest(RationRequest rationRequest) {
        return rationRequestRepository.save(rationRequest);
    }

    public List<RationRequest> getRationRequests(User user) {
        return rationRequestRepository.findByUser(user);
    }

    public RationRequest approveRequest(Long requestId, String comment) {
        RationRequest request = rationRequestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("APPROVED");
        request.setComment(comment);
        return rationRequestRepository.save(request);
    }

    public RationRequest rejectRequest(Long requestId, String comment) {
        RationRequest request = rationRequestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("REJECTED");
        request.setComment(comment);
        return rationRequestRepository.save(request);
    }
}

