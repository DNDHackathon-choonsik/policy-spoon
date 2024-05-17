package com.example.policyspoon.boundedContext.review.dto;

import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.supply.dto.SuppliesResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReviewResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String reviewTitle;
    private String policyTitle;
    private String content;
    private String writer;
    private List<SuppliesResponse> supplies;
    private String category;

    public static ReviewResponse of(Review review) {

        List<SuppliesResponse> supplies = review.getSupplies().stream()
                .map(supply -> SuppliesResponse.builder()
                        .id(supply.getId())
                        .supplies(supply.getSupplies())
                        .build())
                .toList();

        return ReviewResponse.builder()
                .id(review.getId())
                .createdDate(review.getCreatedDate())
                .lastModifiedDate(review.getLastModifiedDate())
                .reviewTitle(review.getReviewTitle())
                .policyTitle(review.getPolicyTitle())
                .content(review.getContent())
                .writer(review.getWriter().getNickname())
                .supplies(supplies)
                .category(review.getCategory())
                .build();
    }


    public static List<ReviewResponse> of(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewResponse::of)
                .toList();
    }

}
