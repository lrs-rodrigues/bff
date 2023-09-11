package com.lrsrodrigues.bffasyncstopm.application.websocket;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.CreateSimulationEvent;
import com.lrsrodrigues.bffasyncstopm.application.websocket.input.CreateSimulationInput;
import com.lrsrodrigues.bffasyncstopm.infrastructure.mediator.Mediator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class SimulationController {

    private final Mediator mediator;

    public SimulationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @MessageMapping("/create_simulate")
    public void createSimulate(@Header("simpSessionId") String sessionId, @Payload CreateSimulationInput input) {
        CreateSimulationEvent event = CreateSimulationEvent.builder()
                .sessionId(sessionId)
                .type(input.type())
                .document(input.document())
                .resaleDocument(input.resaleDocument())
                .value(input.value())
                .entryValue(input.entryValue())
                .build();

        mediator.publish("create_simulation", event);
    }

}


