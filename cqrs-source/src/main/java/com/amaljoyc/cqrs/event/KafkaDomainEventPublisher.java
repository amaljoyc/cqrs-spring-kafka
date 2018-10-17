package com.amaljoyc.cqrs.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amaljoyc on 18.10.18.
 */
@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    @Autowired
    private Source source;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void publish(DomainEvent event) {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("type", event.getType());
            String content = objectMapper.writeValueAsString(event);

            source.output().send(new GenericMessage<>(content, headers));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
