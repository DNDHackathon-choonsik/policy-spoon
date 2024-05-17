package com.example.policyspoon.boundedContext.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtResponse {

    private Long userId;
    private String accessToken;
}
