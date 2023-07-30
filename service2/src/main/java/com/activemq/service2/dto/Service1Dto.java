package com.activemq.service2.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Service1Dto {
    private long userId;
    private String cardType;

    public Service1Dto(Service1Dto service1Dto) {
    }
}
