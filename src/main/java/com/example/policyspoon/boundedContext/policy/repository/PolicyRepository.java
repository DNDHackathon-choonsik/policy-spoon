package com.example.policyspoon.boundedContext.policy.repository;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findAllByCategoryContaining(String category);
}
