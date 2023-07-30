package com.activemq.service2.service;

import com.activemq.service2.util.utility;
import com.activemq.service2.dto.Service1Dto;
import com.activemq.service2.dto.Service2NewDto;
import com.activemq.service2.model.Service2Model;
import com.activemq.service2.repository.Service2Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2UserDataProcessorServices {

    private utility methods;
    @Autowired
    private Service2Repository service2Repository;
    private Service2UserExistenceServices service2UserExistenceServices;
    private Service2UserMappingServices service2UserMappingServices;

    public String getUserData(Service1Dto service1Dto) throws JsonProcessingException {
        String responce;
        boolean check = service2UserExistenceServices.userExistence(service1Dto.getUserId());
        if(check)
        {
            String cardType=service1Dto.getCardType();
            Service2Model service2Model=service2Repository.findById(service1Dto.getUserId()).get();
            Service2NewDto service2NewDto= service2UserMappingServices.mapToUser(service2Model, cardType);
            methods.logger.info(service2NewDto.getUserId()+"  "+service2NewDto.getName()+"  "+service2NewDto.getCardType()+" .");

            methods.logger.info("Sending object to Service3 after converting it into string");
            responce=methods.objectMapper.writeValueAsString(service2NewDto);
            return responce;
        }
        else
        {
            methods.logger.info("Sending message to Service1");
            responce="User not exists!";
            return responce;
        }
    }
}
