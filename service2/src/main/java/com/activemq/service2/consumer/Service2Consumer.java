package com.activemq.service2.consumer;

import com.activemq.service2.util.utility;
import com.activemq.service2.dto.Service1Dto;
import com.activemq.service2.service.Service2UserDataProcessorServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
@EnableJms
public class Service2Consumer {

        private utility methods;
        private Service2UserDataProcessorServices service2UserDataProcessorServices;
        @JmsListener(destination = "service1.queue")
        public void listener(String message) throws JsonProcessingException {
                methods.logger.info("Message received: {}", message);
                Service1Dto service1Dto = methods.objectMapper.readValue(message, Service1Dto.class);
                methods.logger.info("Object received: {}", service1Dto);
                service2UserDataProcessorServices.getUserData(service1Dto);
        }
}
