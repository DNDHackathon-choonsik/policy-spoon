package com.example.policyspoon.boundedContext.supply.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.comment.service.CommentService;
import com.example.policyspoon.boundedContext.supply.dto.SuppliesRequest;
import com.example.policyspoon.boundedContext.supply.dto.SuppliesResponse;
import com.example.policyspoon.boundedContext.supply.entity.Supply;
import com.example.policyspoon.boundedContext.supply.service.SupplyService;
import com.example.policyspoon.boundedContext.user.entity.User;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/review/{reviewId}/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    @PostMapping
    public ResponseEntity<Result> saveSupplies(@RequestBody SuppliesRequest dto,
                                               @PathVariable("reviewId") Long reviewId,
                                               @AuthenticationPrincipal User user) {

        List<SuppliesResponse> response = supplyService.saveSupplies(dto, reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping
    public ResponseEntity<Result> findAll(@PathVariable("reviewId") Long reviewId, @AuthenticationPrincipal User user) {
        List<SuppliesResponse> response = SuppliesResponse.of(supplyService.findAllSupplies(reviewId, user.getId()));

        return ResponseEntity.ok(Result.of(response));
    }

    @PatchMapping
    public ResponseEntity<Result> updateSupplies(@RequestBody SuppliesRequest dto, @PathVariable("reviewId") Long reviewId, @AuthenticationPrincipal User user) {

        List<SuppliesResponse> response = supplyService.updateSupplies(dto, reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }
}
