package com.example.policyspoon.boundedContext.supply.service;

import com.example.policyspoon.base.exception.CustomException;
import com.example.policyspoon.base.exception.ErrorCode;
import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.review.repository.ReviewRepository;
import com.example.policyspoon.boundedContext.supply.dto.SuppliesRequest;
import com.example.policyspoon.boundedContext.supply.dto.SuppliesResponse;
import com.example.policyspoon.boundedContext.supply.entity.Supply;
import com.example.policyspoon.boundedContext.supply.repository.SupplyQueryRepository;
import com.example.policyspoon.boundedContext.supply.repository.SupplyRepository;
import com.example.policyspoon.boundedContext.user.entity.User;
import com.example.policyspoon.boundedContext.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final SupplyQueryRepository supplyQueryRepository;

    @Transactional
    public List<SuppliesResponse> saveSupplies(SuppliesRequest dto, Long reviewId, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        List<Supply> supply = dto.toEntity(review, user);

        List<Supply> array = new ArrayList<>();
        for (Supply save : supply) {
            array.add(supplyRepository.save(save));
        }

        return SuppliesResponse.of(array);
    }

    public List<Supply> findAllSupplies(Long reviewId, Long userId) {
        return supplyQueryRepository.findALlByReviewIdAndUserId(reviewId, userId);
    }

    @Transactional
    public List<SuppliesResponse> updateSupplies(SuppliesRequest dto, Long reviewId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        supplyRepository.deleteAllByReviewId(reviewId);

        return saveSupplies(dto, reviewId, userId);
    }
}
