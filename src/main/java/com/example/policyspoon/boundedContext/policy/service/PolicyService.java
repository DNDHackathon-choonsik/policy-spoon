package com.example.policyspoon.boundedContext.policy.service;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PolicyService {

    private final PolicyRepository policyRepository;

    public List<Policy> findAllByCategoryContaining(String category) {
        return policyRepository.findAllByCategoryContaining(category);
    }
}
