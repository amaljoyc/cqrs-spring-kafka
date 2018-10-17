package com.amaljoyc.cqrs.event;

/**
 * Created by amaljoyc on 18.10.18.
 */
public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
