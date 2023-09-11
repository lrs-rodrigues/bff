package com.lrsrodrigues.bffasyncstopm.infrastructure.mediator;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.Event;

public interface EventHandler {

    void handler(Event eventInput);

}
