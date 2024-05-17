package com.example.policyspoon.boundedContext.policy.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.policy.dto.PolicyResponse;
import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.service.PolicyService;
import com.example.policyspoon.boundedContext.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping
    public ResponseEntity<Result> findAllByCategory(@RequestParam(defaultValue = "") String category,
                                                    @RequestParam(defaultValue = "") String title,
                                                    @RequestParam(defaultValue = "false") Boolean recommend,
                                                    @AuthenticationPrincipal User user) {
        List<PolicyResponse> response = policyService.findAllByCategoryContaining(category, title, recommend, user);

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping("/{policyId}")
    public ResponseEntity<Result> findById(@PathVariable Long policyId) {
        Policy response = policyService.findById(policyId);

        return ResponseEntity.ok(Result.of(response));
    }
}
