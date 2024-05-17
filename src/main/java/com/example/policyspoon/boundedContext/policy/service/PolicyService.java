package com.example.policyspoon.boundedContext.policy.service;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.repository.PolicyQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PolicyService {

    private final PolicyQueryRepository policyRepository;

    public List<Policy> findAllByCategoryContaining(String category, String title) {
        return policyRepository.findAllByCategoryOrTitle(category, title);
    }
}
