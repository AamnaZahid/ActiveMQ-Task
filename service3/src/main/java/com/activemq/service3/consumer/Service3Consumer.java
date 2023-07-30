package com.activemq.service3.consumer;


import com.activemq.service3.dto.Service3Dto;
import com.activemq.service3.service.Service3Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Service3Consumer {

    private final Logger logger = LoggerFactory.getLogger(Service3Consumer.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Service3Services service3Services;


//    @JmsListener(destination = "")
//    public void listener(String message) throws JsonProcessingException {
//
//        logger.info("Message received {} ", message);
//       Service3Dto service3Dto =objectMapper.readValue(message, Service3Dto.class);
//        logger.info("Object received {} ", service3Dto);
//    }



    @JmsListener(destination = "service1.topic")
    public void listenerForService1Response(String message) {
        System.out.println("Response received from Service1: " + message);
        // Process the response message from Service1 (if needed)
    }

    @JmsListener(destination = "service3.topic")
    public void listenerForService3Topic(String message) throws JsonProcessingException {

        logger.info("Message received {} ", message);
        Service3Dto service3Dto =objectMapper.readValue(message, Service3Dto.class);
        logger.info("Object received {} ", service3Dto);
        // Process the message received from Service3 (if needed)
        service3Services.saveUser(service3Dto);

    }
}
