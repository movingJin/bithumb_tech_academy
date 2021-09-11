package com.movingjin.api.kafka.controller;

import com.movingjin.api.kafka.domain.User;
import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final KafkaTemplate<String, User> kafkaTemplate;

    //private static final String TOPIC = "kafka-spring-producer";
    private static final String TOPIC = "TOPIC-01";

    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable final String name){
        User user = new User();
        user.setId("blahblah");
        user.setName(name);
        user.setEmail(name+"@test.com");
        kafkaTemplate.send(TOPIC, user);
        return "Message Published Successfully";
    }


}