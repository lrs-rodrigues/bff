package com.lrsrodrigues.bffasyncstopm.domain.entity.simulation;

import com.lrsrodrigues.bffasyncstopm.domain.entity.EntityDomain;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class SimulationIdentification extends EntityDomain {
    private String type;
    private String document;
    private String resaleDocument;
    private String commissionType;
    private Integer commission;
    private Double value;
    private Double entryValue;
    private String paymentType;
}
