package com.lrsrodrigues.bffasyncstopm.domain.entity.resale;

import java.util.List;

public record ResaleCommission(
        List<Commission> commissions
) { }
