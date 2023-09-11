package com.lrsrodrigues.bffasyncstopm.domain.entity.resale;

public record Commission(
         String type,
         Integer min,
         Integer max,
         Integer standard
) {
}
