package com.activemq.service1.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Service1Consumer {

    private final Logger logger = LoggerFactory.getLogger(Service1Consumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @JmsListener(destination = "service2.queue")
    public void listener(String message) throws JsonProcessingException {
        logger.info("Message received: {}", message);
    }
}
