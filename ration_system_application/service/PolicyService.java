package com.example.ration_system_application.ration_system_application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ration_system_application.ration_system_application.entity.Policy;
import com.example.ration_system_application.ration_system_application.repository.PolicyRepository;


@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    
    public Policy addPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

 
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElseThrow(() -> new RuntimeException("Policy not found"));
    }

   
    public Policy updatePolicy(Long id, Policy updatedPolicy) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        policy.setTitle(updatedPolicy.getTitle());
        policy.setDescription(updatedPolicy.getDescription());
        policy.setEffectiveDate(updatedPolicy.getEffectiveDate());
        policy.setStatus(updatedPolicy.getStatus());
        return policyRepository.save(policy);
    }

   
    public void deletePolicy(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        policyRepository.delete(policy);
    }
}


