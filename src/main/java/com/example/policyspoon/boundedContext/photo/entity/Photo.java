package com.example.policyspoon.boundedContext.photo.entity;

import com.example.policyspoon.base.entity.BaseEntity;
import com.example.policyspoon.boundedContext.review.entity.Review;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEW_PHOTO_TB")
@Builder
public class Photo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_photo_id")
    private Long id;

    @ManyToOne
    @Setter
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "review_photo_path")
    private String path;

    @Column(name = "original_file_name")
    private String name;

}