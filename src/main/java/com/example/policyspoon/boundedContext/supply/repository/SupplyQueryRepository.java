package com.example.policyspoon.boundedContext.supply.repository;

import com.example.policyspoon.boundedContext.supply.entity.QSupply;
import com.example.policyspoon.boundedContext.supply.entity.Supply;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SupplyQueryRepository {

    private final JPAQueryFactory query;
    public List<Supply> findALlByReviewIdAndUserId(Long reviewId, Long userId) {
        return query
                .selectFrom(QSupply.supply)
                .where(
                        QSupply.supply.review.id.eq(reviewId)
                                .and(QSupply.supply.writer.id.eq(userId))
                )
                .orderBy(QSupply.supply.id.desc())
                .fetch();
    }
}