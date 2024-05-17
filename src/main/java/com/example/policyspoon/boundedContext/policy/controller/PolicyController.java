package com.example.policyspoon.boundedContext.policy.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping
    public ResponseEntity<Result> findAllByCategory(@RequestParam String category) {
        List<Policy> response = policyService.findAllByCategoryContaining(category);

        return ResponseEntity.ok(Result.of(response));
    }
}
