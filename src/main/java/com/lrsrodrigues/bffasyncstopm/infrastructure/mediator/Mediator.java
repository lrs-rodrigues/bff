package com.lrsrodrigues.bffasyncstopm.infrastructure.mediator;

import com.lrsrodrigues.bffasyncstopm.application.event.entity.Event;

public interface Mediator {

   void publish(String eventName, Event eventInput);

}
