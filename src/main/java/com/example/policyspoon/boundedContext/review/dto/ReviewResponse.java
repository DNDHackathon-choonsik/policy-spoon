package com.example.policyspoon.boundedContext.review.dto;

import com.example.policyspoon.boundedContext.review.entity.Review;
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
    private String supplies;
    private String category;

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .createdDate(review.getCreatedDate())
                .lastModifiedDate(review.getLastModifiedDate())
                .reviewTitle(review.getReviewTitle())
                .policyTitle(review.getPolicyTitle())
                .content(review.getContent())
                .writer(review.getWriter().getNickname())
                .supplies(review.getSupplies())
                .category(review.getCategory())
                .build();
    }


    public static List<ReviewResponse> of(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewResponse::of)
                .toList();
    }
}
