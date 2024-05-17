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
    public SuppliesResponse saveSupplies(SuppliesRequest dto, Long reviewId, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        Supply supply = dto.toEntity(review, user);

        return SuppliesResponse.of(supplyRepository.save(supply));
    }

    public List<Supply> findAllSupplies(Long reviewId, Long userId) {
        return supplyQueryRepository.findALlByReviewIdAndUserId(reviewId, userId);
    }

    @Transactional
    public SuppliesResponse updateSupplies(SuppliesRequest dto, Long supplyId, Long userId) {


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        Supply supply = supplyRepository.findById(supplyId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_FOUND));

        if (supply.getWriter() != user) {
            throw new CustomException(ErrorCode.DATA_NOT_FOUND);
        }

        updateEachSubjectsItem(dto, supply);

        return SuppliesResponse.of(supply);
    }

    private void updateEachSubjectsItem(SuppliesRequest dto, Supply supplies) {
        if (dto.hasSupplies()) {
            supplies.updateSupplies(dto.getSupplies());
        }
    }
}
