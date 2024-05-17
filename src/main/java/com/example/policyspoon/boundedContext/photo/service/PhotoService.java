package com.example.policyspoon.boundedContext.photo.service;

import static com.example.policyspoon.base.exception.ErrorCode.DATA_NOT_FOUND;
import static com.example.policyspoon.base.exception.ErrorCode.NO_HISTORY;
import static com.example.policyspoon.base.exception.ErrorCode.NO_PERMISSION;

import com.example.policyspoon.base.exception.CustomException;
import com.example.policyspoon.base.utils.S3UploadUtils;
import com.example.policyspoon.boundedContext.photo.dto.PhotoDeleteResponse;
import com.example.policyspoon.boundedContext.photo.dto.PhotoRequest;
import com.example.policyspoon.boundedContext.photo.entity.Photo;
import com.example.policyspoon.boundedContext.photo.repository.PhotoRepository;
import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.review.repository.ReviewRepository;
import com.example.policyspoon.boundedContext.user.entity.User;
import com.example.policyspoon.boundedContext.user.repository.UserRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoService {
    
    private final PhotoRepository photoRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final S3UploadUtils s3UploadUtils;


    @Transactional
    public List<Photo> save(Long reviewId, Long userId, PhotoRequest dto) throws IOException {
        List<Photo> photos = new ArrayList<>();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(NO_HISTORY));

        if (user != review.getWriter()) {
            throw new CustomException(NO_PERMISSION);
        }

        for (MultipartFile file : dto.getPhotos()) {
            String uploadUrl = s3UploadUtils.upload(file, "ps-review-photos");
            String originName = file.getOriginalFilename();

            Photo savedPhoto = photoRepository.save(
                    dto.toEntity(review, uploadUrl, originName));

            photos.add(savedPhoto);
        }

        return photos;
    }

    @Transactional(readOnly = true)
    public Photo findById(Long id) {
        return photoRepository.findById(id)
                .orElseThrow(() -> new CustomException(NO_HISTORY));
    }

    @Transactional(readOnly = true)
    public List<Photo> findAllByReviewId(Long reviewId) {
        return photoRepository.findAllByReviewId(reviewId);
    }

    @Transactional
    public PhotoDeleteResponse deleteAllByReviewId(Long reviewId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(DATA_NOT_FOUND));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(NO_HISTORY));

        if (user != review.getWriter()) {
            throw new CustomException(NO_PERMISSION);
        }

        List<Photo> photos = findAllByReviewId(reviewId);

        for (Photo photo : photos) {
            String path = photo.getPath();
            s3UploadUtils.deleteS3Object("ps-review-photos", path);
        }

        photoRepository.deleteByReviewId(reviewId);

        // 어느 프로필의 사진인지 프로필을 id를 반환
        return PhotoDeleteResponse.builder()
                .id(reviewId)
                .build();
    }
}
