package com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity;

import java.util.List;

public record Condition(
        String id,
        Integer month,
        Double fee,
        List<Installment> installments
) {
}
