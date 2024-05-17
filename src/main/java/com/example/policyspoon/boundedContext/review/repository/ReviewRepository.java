package com.example.policyspoon.boundedContext.review.repository;

import com.example.policyspoon.boundedContext.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
