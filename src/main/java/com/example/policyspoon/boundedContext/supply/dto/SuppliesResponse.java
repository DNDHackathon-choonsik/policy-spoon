package com.example.policyspoon.boundedContext.supply.dto;

import com.example.policyspoon.boundedContext.supply.entity.Supply;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SuppliesResponse {

    private Long id;
    private String supplies;

    public static SuppliesResponse of(Supply supplies) {

        return SuppliesResponse.builder()
                .id(supplies.getId())
                .supplies(supplies.getSupplies())
                .build();
    }

    public static List<SuppliesResponse> of(List<Supply> supplies) {
        return supplies.stream()
                .map(SuppliesResponse::of)
                .toList();
    }

}
