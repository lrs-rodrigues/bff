package com.lrsrodrigues.bffasyncstopm.application.event.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Event {

    private UUID eventId = UUID.randomUUID();
    private String sessionId;
    public Event(String sessionId) {
        this.sessionId = sessionId;
    }
}
