package com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity;

import java.util.List;

public record Financing(
        String financeType,
        List<Condition> conditions
) {
}
