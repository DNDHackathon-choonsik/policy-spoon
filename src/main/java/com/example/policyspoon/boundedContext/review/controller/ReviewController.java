package com.example.policyspoon.boundedContext.review.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.review.dto.ReviewDeleteResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewRequest;
import com.example.policyspoon.boundedContext.review.dto.ReviewResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewTitleResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewUpdateRequest;
import com.example.policyspoon.boundedContext.review.service.ReviewService;
import com.example.policyspoon.boundedContext.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Tag(name = "후기 API", description = "후기에 대한 설명입니다.")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/")
    @Operation(summary = "summary", description = "desc")
    public String test() {
        return "asdfas";
    }

    @PostMapping
    public ResponseEntity<Result> save(@AuthenticationPrincipal User user, @RequestBody @Valid ReviewRequest request) throws IOException {
        ReviewResponse response = ReviewResponse.of(reviewService.save(user.getId(), request));

        return ResponseEntity.ok(Result.of(response));
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Result> findReview(@PathVariable Long reviewId,
                                               @AuthenticationPrincipal User user) {

        ReviewResponse response = reviewService.findReview(reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping("/list")
    public ResponseEntity<Result> findReviewList(@AuthenticationPrincipal User user) {

        List<ReviewTitleResponse> response = reviewService.findReviewList(user.getId());

        return ResponseEntity.ok(Result.of(response));
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<Result> updateSchedule(@RequestBody ReviewUpdateRequest dto,
                                                 @PathVariable("reviewId") Long reviewId,
                                                 @AuthenticationPrincipal User user) {

        ReviewResponse response = reviewService.updateReview(dto, reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Result> deleteSchedule(@PathVariable("reviewId") Long reviewId,
                                                 @AuthenticationPrincipal User user) {

        ReviewDeleteResponse response = reviewService.deleteReview(reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping("/searching")
    public ResponseEntity<Result> findAll(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            @AuthenticationPrincipal User user) {

        List<ReviewTitleResponse> reviews = reviewService.findAllOfReviews(keyword, user.getId());

        List<Object> response = new ArrayList<>();
        response.addAll(reviews);

        return ResponseEntity.ok(Result.of(response));
    }
}
