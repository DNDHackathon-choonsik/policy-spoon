package com.example.policyspoon.boundedContext.photo.controller;

import com.example.policyspoon.boundedContext.photo.service.PhotoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/{reviewId}/photos")
@Tag(name = "사진 API", description = "컨트롤러에 대한 설명입니다.")
public class PhotoController {

    private final PhotoService photoService;
}
