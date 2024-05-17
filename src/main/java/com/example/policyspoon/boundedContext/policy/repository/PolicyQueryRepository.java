package com.example.policyspoon.boundedContext.policy.repository;

import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.policyspoon.boundedContext.policy.entity.QPolicy.policy;

@Repository
@RequiredArgsConstructor
public class PolicyQueryRepository {

    private final JPAQueryFactory query;

    public List<Policy> findAllByCategoryOrTitle(String category, String title) {
        return query
                .selectFrom(policy)
                .where(
                        categoryContains(category),
                        titleContains(title)
                )
                .fetch();
    }

    private BooleanExpression titleContains(String title) {
        if(!StringUtils.hasText(title)) {
            return null;
        }
        return policy.title.contains(title);
    }

    private BooleanExpression categoryContains(String category) {
        if(!StringUtils.hasText(category)) {
            return null;
        }
        return policy.category.contains(category);
    }

    public List<Policy> findAllByAge(int currentAge) {
        return query
                .selectFrom(policy)
                .where(policy.startAge.loe(currentAge), policy.endAge.goe(currentAge))
                .fetch();
    }
}
