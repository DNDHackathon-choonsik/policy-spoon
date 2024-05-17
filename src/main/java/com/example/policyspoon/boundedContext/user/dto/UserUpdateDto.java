package com.example.policyspoon.boundedContext.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserUpdateDto {

    private LocalDate birth;
    private String area;
    private String gender;
}
