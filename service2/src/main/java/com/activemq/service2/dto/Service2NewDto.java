package com.activemq.service2.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service2NewDto {
    private long userId;
    private String name;
    private String cardType;
    private String email;
    private String phNo;
}
