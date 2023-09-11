package com.lrsrodrigues.bffasyncstopm.domain.gateway;


import com.lrsrodrigues.bffasyncstopm.domain.entity.EntityDomain;

public interface UpdateSimulationGateway {

    String handler(String id, EntityDomain entityDomain);

}
