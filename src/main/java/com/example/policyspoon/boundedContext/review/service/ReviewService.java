package com.example.policyspoon.boundedContext.review.service;

import static com.example.policyspoon.base.exception.ErrorCode.DATA_NOT_FOUND;
import static com.example.policyspoon.base.exception.ErrorCode.NO_PERMISSION;

import com.example.policyspoon.base.exception.CustomException;
import com.example.policyspoon.boundedContext.review.dto.ReviewDeleteResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewRequest;
import com.example.policyspoon.boundedContext.review.dto.ReviewResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewTitleResponse;
import com.example.policyspoon.boundedContext.review.dto.ReviewUpdateRequest;
import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.review.repository.ReviewQueryRepository;
import com.example.policyspoon.boundedContext.review.repository.ReviewRepository;
import com.example.policyspoon.boundedContext.user.entity.User;
import com.example.policyspoon.boundedContext.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewQueryRepository reviewQueryRepository;

    @Transactional
    public Review save(Long userId, ReviewRequest request) {
        User writer = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND, "userId="+userId));

        writer.setPoint(writer.getPoint() + 3);

        Review review = Review.builder()
                .reviewTitle(request.getReviewTitle())
                .policyTitle(request.getPolicyTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .supplies(request.getSupplies())
                .writer(writer)
                .build();



        return reviewRepository.save(review);
    }

    @Transactional
    public ReviewDeleteResponse deleteReview(Long reviewId, Long userId) {

        User user = CurrentUser(userId);
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

        if (review.getWriter() != user) {
            throw new CustomException(NO_PERMISSION);
        }

        reviewRepository.deleteById(reviewId);
        return ReviewDeleteResponse.builder()
                .id(reviewId)
                .build();
    }

    private User CurrentUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(NO_PERMISSION));
    }


    @Transactional
    public ReviewResponse updateReview(ReviewUpdateRequest dto, Long reviewId, Long userId) {

        User user = CurrentUser(userId);
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

        if (review.getWriter() != user) {
            throw new CustomException(NO_PERMISSION);
        }

        update(dto, review);

        return ReviewResponse.of(review);
    }

    private void update(ReviewUpdateRequest dto, Review review) {
        if (dto.hasReviewTitle()) {
            review.updateReviewTitle(dto.getReviewTitle());
        }
        if (dto.hasContent()) {
            review.updateContent(dto.getContent());
        }
        if (dto.hasSupplies()) {
            review.updateSupplies(dto.getSupplies());
        }
    }

    @Transactional
    public ReviewResponse findReview(Long reviewId, Long userId) {
        User user = CurrentUser(userId);
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

        if (review.getWriter() != user) {
            throw new CustomException(NO_PERMISSION);
        }

        if(user.getPoint() <= 0) {
            throw new CustomException(NO_PERMISSION);
        }
        user.setPoint(user.getPoint() - 1);

        return ReviewResponse.of(review);
    }

    public List<ReviewTitleResponse> findReviewList(Long userId) {
        User currentUser = CurrentUser(userId);

        return ReviewTitleResponse.of(reviewQueryRepository.findAllByUserId(currentUser.getId()));
    }

    public List<ReviewTitleResponse> findAllOfReviews(String title, Long userId) {
        List<Review> consultations = reviewQueryRepository.findAll(title, userId);

        return consultations.stream()
                .map(ReviewTitleResponse::of)
                .toList();
    }
}
