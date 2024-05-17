package com.example.policyspoon.boundedContext.photo.repository;

import com.example.policyspoon.boundedContext.photo.entity.Photo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByReviewId(Long reviewId);

    void deleteByReviewId(Long reviewId);
}
