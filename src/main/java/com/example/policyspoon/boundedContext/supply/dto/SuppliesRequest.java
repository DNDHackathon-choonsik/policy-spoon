package com.example.policyspoon.boundedContext.supply.dto;

import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.supply.entity.Supply;
import com.example.policyspoon.boundedContext.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesRequest {

    private List<String> supplies;

    public List<Supply> toEntity(Review review, User user) {
        return supplies.stream()
                .map(e -> Supply.builder().review(review).writer(user).supplies(e).build())
                .collect(Collectors.toList());
    }

    public boolean hasSupplies() {
        return supplies != null;
    }
}