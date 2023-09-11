package com.lrsrodrigues.bffasyncstopm.infrastructure.cache.entity;

import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Client;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Financing;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Resale;
import com.lrsrodrigues.bffasyncstopm.infrastructure.client.simulator.entity.Simulation;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Simulation")
public record SimulationEntity(
        String idJornada,
        String idSimulation,
        Client client,
        Resale resale,
        Simulation simulation,
        Financing financing
) {


}
