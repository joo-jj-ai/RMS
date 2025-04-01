package com.example.ration_system_application.ration_system_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ration_system_application.ration_system_application.entity.Policy;
import com.example.ration_system_application.ration_system_application.service.PolicyService;

@CrossOrigin
@RestController
@RequestMapping("/policies")


public class PolicyController {
    @Autowired
    private PolicyService policyService;

    
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    
    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    
    @PostMapping
    public Policy addPolicy(@RequestBody Policy policy) {
        return policyService.addPolicy(policy);
    }

   
    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        return policyService.updatePolicy(id, updatedPolicy);
    }

    
    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
}


