package com.deliverBoy.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliverBoy.config.AppConstants;

import ch.qos.logback.classic.Logger;

@Service
public class KafkaService {

    //to produce message we are using kafka template
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    //to provide logger
    private Logger logger=(Logger) LoggerFactory.getLogger(KafkaService.class);
    public boolean updateLocation(String location)
    {
       
            kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);//topicname and its message
            this.logger.info("message produced ");
       
        return true;
    }
}
