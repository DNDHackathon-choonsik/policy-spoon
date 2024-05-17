package com.example.policyspoon.boundedContext.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Tag(name = "후기 API", description = "컨트롤러에 대한 설명입니다.")
public class ReviewController {

    @GetMapping("/")
    @Operation(summary = "summary", description = "desc")
    public String test() {
        return "asdfas";
    }
}
