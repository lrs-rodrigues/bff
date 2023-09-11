package com.lrsrodrigues.bffasyncstopm.domain.gateway;

import com.lrsrodrigues.bffasyncstopm.domain.entity.simulation.SimulationFinancing;
import com.lrsrodrigues.bffasyncstopm.domain.entity.simulation.SimulationIdentification;
import com.lrsrodrigues.bffasyncstopm.domain.entity.simulation.SimulationInstallments;

public interface FetchSimulationGateway {

    SimulationIdentification getIdentificationById(String id);
    SimulationFinancing getFinancingById(String id);
    SimulationInstallments getInstallmentsById(String id);

}
