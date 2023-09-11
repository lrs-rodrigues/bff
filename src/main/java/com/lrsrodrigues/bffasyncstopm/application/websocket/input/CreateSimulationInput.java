package com.lrsrodrigues.bffasyncstopm.application.websocket.input;

public record CreateSimulationInput(
        String type,
        String document,
        String resaleDocument,
        Double value,
        Double entryValue
) {
}
