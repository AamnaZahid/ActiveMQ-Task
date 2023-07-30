package com.activemq.service3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Service3Dto {
    private long userId;
    private String name;
    private String cardType;
    private String email;
    private String phNo;
}
