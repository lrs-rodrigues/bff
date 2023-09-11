package com.lrsrodrigues.bffasyncstopm.infrastructure.mediator;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.Event;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventMediator implements Mediator {

    private final QueueMessagingTemplate messagingTemplate;

    public EventMediator(QueueMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void publish(String eventName, Event eventInput) {
        messagingTemplate.convertAndSend(eventName, eventInput);
    }

}
