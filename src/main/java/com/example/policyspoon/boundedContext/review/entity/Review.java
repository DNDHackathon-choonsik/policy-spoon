package com.example.policyspoon.boundedContext.review.entity;

import com.example.policyspoon.base.entity.BaseEntity;
import com.example.policyspoon.boundedContext.photo.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "REVIEW_TB")
@Builder(toBuilder = true)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="review_id")
    private Long id;

    @NotBlank
    @Column(name = "review_title")
    private String reviewTitle;

    @NotBlank
    @Column(name = "policy_title")
    private String policyTitle;

    @NotBlank
    @Column(name ="content")
    private String content;

    @NotBlank
    @Column(name ="category")
    private String category;

    @NotBlank
    @Column(name ="supplies")
    private String supplies;

    @Builder.Default
    @OneToMany(mappedBy = "review",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Photo> reviews = new ArrayList<>();
}
