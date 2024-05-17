package com.example.policyspoon.boundedContext.policy.service;

import com.example.policyspoon.base.exception.CustomException;
import com.example.policyspoon.base.exception.ErrorCode;
import com.example.policyspoon.boundedContext.policy.dto.PolicyResponse;
import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.repository.PolicyQueryRepository;
import com.example.policyspoon.boundedContext.policy.repository.PolicyRepository;
import com.example.policyspoon.boundedContext.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PolicyService {

    private final PolicyQueryRepository policyQueryRepository;
    private final PolicyRepository policyRepository;

    public List<PolicyResponse> findAllByCategoryContaining(String category, String title, Boolean recommend, User user) {
        if(recommend) {
            int birth = user.getBirth().getYear();
            int now = LocalDate.now().getYear();
            int currentAge = now - birth;
            return PolicyResponse.of(policyQueryRepository.findAllByAge(currentAge));
        }
        return PolicyResponse.of(policyQueryRepository.findAllByCategoryOrTitle(category, title));
    }

    public Policy findById(Long policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));
    }
}
