package com.example.policyspoon.boundedContext.policy.repository;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
