package com.activemq.service2.util;

import com.activemq.service2.consumer.Service2Consumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class utility {

    public static final Logger logger = LoggerFactory.getLogger(Service2Consumer.class);
    @Autowired
    public ObjectMapper objectMapper;

}
