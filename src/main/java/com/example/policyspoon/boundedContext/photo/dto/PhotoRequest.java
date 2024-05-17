package com.example.policyspoon.boundedContext.photo.dto;

import com.example.policyspoon.boundedContext.photo.entity.Photo;
import com.example.policyspoon.boundedContext.review.entity.Review;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoRequest {
    @Size(max = 2)
    private List<MultipartFile> photos;

    public Photo toEntity(Review review, String uploadUrl, String originName) {
        return Photo.builder()
                .review(review)
                .path(uploadUrl)
                .name(originName)
                .build();
    }
}
