package com.example.policyspoon.boundedContext.supply.repository;

import com.example.policyspoon.boundedContext.supply.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
