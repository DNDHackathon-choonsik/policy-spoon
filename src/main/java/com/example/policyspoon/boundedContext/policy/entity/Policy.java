package com.example.policyspoon.boundedContext.policy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2000)
    private String title; // 정책 이름
    @Column(columnDefinition = "TEXT")
    private String code; // 정책 번호
    @Column(columnDefinition = "TEXT")
    private String category; // 정책 분야
    @Column(columnDefinition = "TEXT")
    private String supportDetail; // 지원 내용
    @Column(columnDefinition = "TEXT")
    private String operationPeriod; // 사업 운영 기간
    @Column(columnDefinition = "TEXT")
    private String applyPeriod; // 사업 신청 기간
    @Column(columnDefinition = "TEXT")
    private String supportScale; // 지원 규모
    @Column(columnDefinition = "TEXT")
    private String note; // 비고
    private Integer startAge; // 시작 나이
    private Integer endAge; // 끝 나이
    @Column(columnDefinition = "TEXT")
    private String areaIncome; // 거주지 및 소득
    @Column(columnDefinition = "TEXT")
    private String education; // 학력
    @Column(columnDefinition = "TEXT")
    private String major; // 전공
    @Column(columnDefinition = "TEXT")
    private String employmentStatus; // 취업 상태
    @Column(columnDefinition = "TEXT")
    private String specialization; // 특화 분야
    @Column(columnDefinition = "TEXT")
    private String additionalClue; // 추가 단서 사항
    @Column(columnDefinition = "TEXT")
    private String restrictBoundary; // 참여 제한 대상
    @Column(columnDefinition = "TEXT")
    private String url; // 상세 페이지 url
//    @Column(columnDefinition = "TEXT")
//    private String applicationProcess; // 신청 절차
//    @Column(columnDefinition = "TEXT")
//    private String judgePresentation; // 심사 및 발표
//    @Column(columnDefinition = "TEXT")
//    private String applicationSite; // 신청 사이트
//    @Column(columnDefinition = "TEXT")
//    private String submitDocument; // 제출 서류
//    @Column(columnDefinition = "TEXT")
//    private String etcInformation; // 기타 유익 정보
//    @Column(columnDefinition = "TEXT")
//    private String hostOrganization; // 주관 기관
//    @Column(columnDefinition = "TEXT")
//    private String operatingOrganization; // 운영 기관
//    @Column(columnDefinition = "TEXT")
//    private String referenceSite1; // 사업 참고 사이트 1
//    @Column(columnDefinition = "TEXT")
//    private String referenceSite2; // 사업 참고 사이트 2
}
