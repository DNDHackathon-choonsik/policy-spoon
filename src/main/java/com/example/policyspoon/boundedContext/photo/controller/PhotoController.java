package com.example.policyspoon.boundedContext.photo.controller;

import com.example.policyspoon.base.response.Result;
import com.example.policyspoon.boundedContext.photo.dto.PhotoDeleteResponse;
import com.example.policyspoon.boundedContext.photo.dto.PhotoRequest;
import com.example.policyspoon.boundedContext.photo.dto.PhotoResponse;
import com.example.policyspoon.boundedContext.photo.service.PhotoService;
import com.example.policyspoon.boundedContext.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/{reviewId}/photos")
@Tag(name = "사진 API", description = "컨트롤러에 대한 설명입니다.")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    public ResponseEntity<Result> save(@PathVariable Long processId, @AuthenticationPrincipal User user,
                                       @Valid PhotoRequest dto) throws IOException {
        List<PhotoResponse> response = PhotoResponse.of(
                photoService.save(processId, user.getId(), dto));

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping("/{photoId}")
    public ResponseEntity<Result> findById(@PathVariable Long processId, @PathVariable Long photoId) {
        PhotoResponse response = PhotoResponse.of(photoService.findById(photoId));

        return ResponseEntity.ok(Result.of(response));
    }

    @GetMapping
    public ResponseEntity<Result> findAll(@PathVariable Long reviewId) {
        List<PhotoResponse> response = PhotoResponse.of(
                photoService.findAllByReviewId(reviewId));

        return ResponseEntity.ok(Result.of(response));
    }

    @DeleteMapping
    public ResponseEntity<Result> delete(@PathVariable Long reviewId, @AuthenticationPrincipal User user) {
        PhotoDeleteResponse response = photoService.deleteAllByReviewId(
                reviewId, user.getId());

        return ResponseEntity.ok(Result.of(response));
    }
}
