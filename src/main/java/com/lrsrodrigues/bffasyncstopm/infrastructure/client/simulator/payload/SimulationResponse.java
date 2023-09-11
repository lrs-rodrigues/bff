package com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.payload;

import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Client;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Financing;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Resale;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Simulation;

public record SimulationResponse(
        String id,
        String idJornada,
        Client client,
        Resale resale,
        Simulation simulation,
        Financing financing
) {
}
