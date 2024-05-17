package com.example.policyspoon.boundedContext.review.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ReviewUpdateRequest {
    private String reviewTitle;
    private String content;

    public boolean hasReviewTitle() {
        return reviewTitle != null;
    }

    public boolean hasContent() {
        return content != null;
    }

}
