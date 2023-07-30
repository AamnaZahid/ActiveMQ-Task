package com.activemq.service2.service;

import com.activemq.service2.dto.Service2NewDto;
import com.activemq.service2.model.Service2Model;
import org.springframework.stereotype.Service;

@Service
public class Service2UserMappingServices {
    public Service2NewDto mapToUser(Service2Model service2Model, String cardType)
    {
        Service2NewDto service2NewDto = new Service2NewDto();
        service2NewDto.setUserId(service2Model.getUserId());
        service2NewDto.setName(service2Model.getName());
        service2NewDto.setCardType(cardType);
        service2NewDto.setEmail(service2Model.getEmail());
        service2NewDto.setPhNo(service2Model.getPh_no());
        return service2NewDto;
    }
}
