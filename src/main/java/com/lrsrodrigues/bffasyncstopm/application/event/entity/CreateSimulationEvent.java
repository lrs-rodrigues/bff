package com.lrsrodrigues.bffasyncstopm.application.event.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateSimulationEvent extends Event {

    private String type;
    private String document;
    private String resaleDocument;
    private Double value;
    private Double entryValue;

    @Builder
    public CreateSimulationEvent(String sessionId, String type, String document, String resaleDocument, Double value, Double entryValue) {
        super(sessionId);
        this.type = type;
        this.document = document;
        this.resaleDocument = resaleDocument;
        this.value = value;
        this.entryValue = entryValue;
    }
}
