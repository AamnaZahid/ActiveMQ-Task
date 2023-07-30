package com.activemq.service3.configuration;


import jakarta.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Service3JmsConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("service2.queue");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}