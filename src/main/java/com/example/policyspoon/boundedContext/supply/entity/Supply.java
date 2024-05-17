package com.example.policyspoon.boundedContext.supply.entity;

import com.example.policyspoon.base.entity.BaseEntity;
import com.example.policyspoon.boundedContext.review.entity.Review;
import com.example.policyspoon.boundedContext.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name = "SUPPLY_TB")
public class Supply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_supply_id")
    private Long id;

    @ManyToOne
    @Setter
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name ="supplies")
    private String supplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    public void updateSupplies(String supplies) {
        this.supplies = supplies;
    }

}
