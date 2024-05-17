package com.example.policyspoon.boundedContext.supply.dto;

import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.supply.entity.Supply;
import com.example.policyspoon.boundedContext.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesRequest {

    private String supplies;

    public Supply toEntity(Review review, User user) {
        return Supply.builder()
                .review(review)
                .supplies(this.supplies)
                .writer(user)
                .build();
    }

    public boolean hasSupplies() {
        return supplies != null;
    }
}