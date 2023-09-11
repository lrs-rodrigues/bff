package com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.payload;

import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Client;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Resale;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Simulation;

public record SimulationRequest(
        String idJornada,
        Client client,
        Resale resale,
        Simulation simulation
) {
}
