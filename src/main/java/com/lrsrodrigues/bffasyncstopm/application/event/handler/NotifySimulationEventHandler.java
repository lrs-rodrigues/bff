package com.lrsrodrigues.bffasyncstopm.application.event.handler;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.Event;
import com.lrsrodrigues.bffasyncstopm.application.event.entity.NotifySimulationEvent;
import com.lrsrodrigues.bffasyncstopm.infrastructure.cache.SimulationDatabaseCache;
import com.lrsrodrigues.bffasyncstopm.infrastructure.cache.entity.SimulationEntity;
import com.lrsrodrigues.bffasyncstopm.infrastructure.mediator.EventHandler;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotifySimulationEventHandler implements EventHandler {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final SimulationDatabaseCache databaseCache;

    public NotifySimulationEventHandler(SimpMessagingTemplate simpMessagingTemplate, SimulationDatabaseCache databaseCache) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.databaseCache = databaseCache;
    }

    @Override
    @SqsListener("notify_simulation")
    public void handler(Event eventInput) {
        if (eventInput instanceof NotifySimulationEvent event) {
            MessageHeaders headers = createHeaders(event.getSessionId());
            SimulationEntity simulationEntity = databaseCache.getByIdJornada(event.getJourneyId());

            switch (event.getNotificationType()) {
                case NOTIFY_ALL -> {
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/identification", "PAYLOAD", headers);
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/financing", "PAYLOAD", headers);
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/installments", "PAYLOAD", headers);
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/discounts", "PAYLOAD", headers);
                }
                case NOTIFY_INSTALLMENTS -> simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/installments", "PAYLOAD", headers);
                case NOTIFY_DISCOUNT_INSTALLMENTS -> {
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/installments", "PAYLOAD", headers);
                    simpMessagingTemplate.convertAndSendToUser(event.getSessionId(), "/topic/simulation/discounts", "PAYLOAD", headers);
                }
            }

        }
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }

}
