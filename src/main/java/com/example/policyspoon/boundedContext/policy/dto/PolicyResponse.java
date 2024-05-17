package com.example.policyspoon.boundedContext.policy.dto;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class PolicyResponse {

    private Long policyId;
    private String title;
    private String category;

    public static List<PolicyResponse> of(List<Policy> policies) {
        return policies.stream()
                .map(PolicyResponse::of)
                .collect(Collectors.toList());
    }

    public static PolicyResponse of(Policy policy) {
        return PolicyResponse.builder()
                .policyId(policy.getId())
                .title(policy.getTitle())
                .category(policy.getCategory())
                .build();
    }
}
