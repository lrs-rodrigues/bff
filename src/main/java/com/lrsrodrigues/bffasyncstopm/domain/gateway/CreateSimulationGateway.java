package com.lrsrodrigues.bffasyncstopm.domain.gateway;

import com.lrsrodrigues.bffasyncstopm.domain.entity.EntityDomain;

public interface CreateSimulationGateway {

    String handler(EntityDomain entityDomain);

}
