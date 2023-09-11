package com.lrsrodrigues.bffasyncstopm.application.event.entity;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.enums.NotificationType;
import lombok.Getter;

@Getter
public class NotifySimulationEvent extends Event {

    private String journeyId;
    private NotificationType notificationType;


    public NotifySimulationEvent(String sessionId, String journeyId, NotificationType notificationType) {
        super(sessionId);
        this.journeyId = journeyId;
        this.notificationType = notificationType;
    }

}
