package com.deliverBoy.controller;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverBoy.service.KafkaService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation()
    {
       // kafkaService.updateLocation(location);
       for(int i=1;i<=1000000;i++)
       {
       kafkaService.updateLocation("("+Math.round(Math.random()*100)+" , "+Math.round(Math.random()*100)+")");
       }
       return new ResponseEntity<>(Map.of("message","location updated"),HttpStatus.OK);
    }
}
