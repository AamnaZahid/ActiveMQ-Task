package com.activemq.service2.controller;

import com.activemq.service2.util.utility;
import com.activemq.service2.dto.Service1Dto;
import com.activemq.service2.service.Service2UserDataProcessorServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Service2ControllerMappingUser {
    private utility methods;
    @Autowired
    private JmsTemplate jmsTemplate;
    private Service2UserDataProcessorServices service2UserDataProcessorServices;

    @RequestMapping(value = "/checkuser/{userid}",method = RequestMethod.POST)
    public void checkUserInDb(@RequestBody Service1Dto service1Dto) throws JsonProcessingException {
        String responce = service2UserDataProcessorServices.getUserData(service1Dto);
        methods.logger.info("Response received from service2Services.getUserData: {}", responce);

        if (responce.equals("User not exists!"))
        {
            jmsTemplate.convertAndSend("service1.topic",responce);

        }
        else {
            jmsTemplate.convertAndSend("service3.topic",responce);
        }
    }
}
