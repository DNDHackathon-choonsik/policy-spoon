package com.example.policyspoon.boundedContext.review.dto;

import com.example.policyspoon.boundedContext.review.entity.Review;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewTitleResponse {
    private Long id;
    private String reviewTitle;
    private String category;

    public static ReviewTitleResponse of(Review reviews) {
        return ReviewTitleResponse.builder()
                .id(reviews.getId())
                .reviewTitle(reviews.getReviewTitle())
                .category(reviews.getCategory())
                .build();
    }

    public static List<ReviewTitleResponse> of(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewTitleResponse::of)
                .toList();
    }
}
