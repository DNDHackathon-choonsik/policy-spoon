package com.example.policyspoon.boundedContext.user.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.user.dto.JwtResponse;
import com.example.policyspoon.boundedContext.user.dto.UserUpdateDto;
import com.example.policyspoon.boundedContext.user.entity.User;
import com.example.policyspoon.boundedContext.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login/oauth2/code/{registrationId}")
    public ResponseEntity<Result> redirect(
            @PathVariable("registrationId") String registrationId,
            @RequestParam("code") String code,
            @RequestParam("state") String state
    ) {
        JwtResponse response = userService.login(code);

        return ResponseEntity.ok(Result.of(response));
    }

    @PatchMapping("/users")
    public ResponseEntity<Result> update(@RequestBody UserUpdateDto dto, @AuthenticationPrincipal User user) {
        User updatedUser = userService.update(user.getId(), dto);

        return ResponseEntity.ok(Result.of(updatedUser));
    }

    @GetMapping("/users")
    public ResponseEntity<Result> me(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(Result.of(user));
    }
}
