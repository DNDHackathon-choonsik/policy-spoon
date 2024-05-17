package com.example.policyspoon.boundedContext.review.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequest {

    @NotBlank
    @Length(max = 20)
    private String reviewTitle;

    @NotBlank
    @Length(max = 20)
    private String policyTitle;

    @NotBlank
    private String content;

    private String supplies;

    @NotBlank
    private String category;
}
