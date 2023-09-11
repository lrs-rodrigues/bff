package com.lrsrodrigues.bffasyncstopm.application.event.handler;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.CreateSimulationEvent;
import com.lrsrodrigues.bffasyncstopm.application.event.entity.Event;
import com.lrsrodrigues.bffasyncstopm.application.event.entity.NotifySimulationEvent;
import com.lrsrodrigues.bffasyncstopm.application.event.entity.enums.NotificationType;
import com.lrsrodrigues.bffasyncstopm.domain.entity.resale.Commission;
import com.lrsrodrigues.bffasyncstopm.domain.entity.simulation.SimulationIdentification;
import com.lrsrodrigues.bffasyncstopm.domain.gateway.CreateSimulationGateway;
import com.lrsrodrigues.bffasyncstopm.domain.usecase.identification.ApplyCommissionStandardUseCase;
import com.lrsrodrigues.bffasyncstopm.domain.usecase.identification.ApplyPaymentTypeUseCase;
import com.lrsrodrigues.bffasyncstopm.infrastructure.mediator.EventHandler;
import com.lrsrodrigues.bffasyncstopm.infrastructure.mediator.Mediator;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class CreateSimulationEventHandler implements EventHandler {

    private final ApplyCommissionStandardUseCase applyCommissionStandardUseCase;
    private final ApplyPaymentTypeUseCase applyPaymentTypeUseCase;
    private final CreateSimulationGateway createSimulationGateway;

    private final Mediator mediator;

    public CreateSimulationEventHandler(ApplyCommissionStandardUseCase applyCommissionStandardUseCase, ApplyPaymentTypeUseCase applyPaymentTypeUseCase, CreateSimulationGateway createSimulationGateway, Mediator mediator) {
        this.applyCommissionStandardUseCase = applyCommissionStandardUseCase;
        this.applyPaymentTypeUseCase = applyPaymentTypeUseCase;
        this.createSimulationGateway = createSimulationGateway;
        this.mediator = mediator;
    }

    @Override
    @SqsListener("create_simulation")
    public void handler(Event eventInput) {
        if (eventInput instanceof CreateSimulationEvent event) {
            Commission commission = applyCommissionStandardUseCase.execute(event.getResaleDocument());
            String paymentType = applyPaymentTypeUseCase.execute(event.getDocument());

            SimulationIdentification identification = SimulationIdentification
                    .builder()
                        .type(event.getType())
                        .document(event.getDocument())
                        .resaleDocument(event.getResaleDocument())
                        .commission(commission.standard())
                        .commissionType(commission.type())
                        .value(event.getValue())
                        .entryValue(event.getEntryValue())
                        .paymentType(paymentType)
                    .build();

            String journeyId = createSimulationGateway.handler(identification);

            mediator.publish("notify_simulation", new NotifySimulationEvent(event.getSessionId(), journeyId, NotificationType.NOTIFY_ALL));
        }
    }

}
