package com.activemq.service3.controller;

import com.activemq.service3.model.Service3Model;
import com.activemq.service3.repository.Service3Repository;
import com.activemq.service3.service.Service3Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Service3Controller {

    private final Logger logger = LoggerFactory.getLogger(Service3Controller.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Queue queue;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Service3Services service3Services;

    @Autowired
    private Service3Repository service3Repository;



    @GetMapping("/getuser/{id}")
    public Optional<Service3Model> getUserById(@PathVariable Long id) {

        logger.info("Sending Response to service2Services");
        logger.info("Card has been created for userid :"+ id);
        jmsTemplate.convertAndSend(queue,"Card has been created for userid :"+ id);
        return service3Services.getUserById(id);
    }


}

