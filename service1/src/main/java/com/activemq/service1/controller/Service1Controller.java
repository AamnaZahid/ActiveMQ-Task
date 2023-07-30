package com.activemq.service1.controller;

import com.activemq.service1.dto.Service1Dto;
import com.activemq.service1.model.Service1Model;
import com.activemq.service1.service.Service1Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Service1Controller {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
   private Service1Services service1Services;

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public List<Service1Model> getAllUsers (){
        return service1Services.getUser();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody Service1Dto service1Dto) throws JsonProcessingException {
        jmsTemplate.convertAndSend(queue,objectMapper.writeValueAsString(service1Dto));
        service1Services.addUser(service1Dto);
        return "UserData Added Successfully and Also Send to the service1.queue";
    }

}
