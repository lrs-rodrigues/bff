package com.lrsrodrigues.bffasyncstopm.infrastructure.cache;

import com.lrsrodrigues.bffasyncstopm.infrastructure.cache.entity.SimulationEntity;
import org.springframework.stereotype.Component;

@Component
public class SimulationDatabaseCache  {

    public SimulationEntity getByIdJornada(String idJornada) {
        return null;
    }

    public void persistInCache(String idJornada, SimulationEntity entity) {

    }

}
