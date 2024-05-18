package com.example.policyspoon.boundedContext.review.repository;

import static com.example.policyspoon.boundedContext.review.entity.QReview.review;

import com.example.policyspoon.boundedContext.review.entity.Review;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Slf4j
@Repository
@RequiredArgsConstructor
public class ReviewQueryRepository {

    private final JPAQueryFactory query;

    public List<Review> findAllByCategory(String category) {
        return query
                .selectFrom(review)
                .where(
                        categoryEq(category)
                )
                .orderBy(review.id.desc())
                .fetch();
    }

    private BooleanExpression categoryEq(String category) {
        if(!StringUtils.hasText(category)) {
            return null;
        }
        return review.category.eq(category);
    }

    public List<Review> findAll(String title) {
        return query
                .selectFrom(review)
                .where(
                        review.policyTitle.like("%" + title + "%")
                )
                .orderBy(review.id.desc())
                .fetch();
    }
}
