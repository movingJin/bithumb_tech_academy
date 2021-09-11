package com.movingjin.api.kafka.service;

import com.movingjin.api.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @KafkaListener(topics = "TOPIC-01", containerFactory = "userKafkaListenerFactory")
    public void listenWithHeaders(
        @Payload User message,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
            System.out.println("Received Message: \n" + message + " from Partition " + partition);
        }
}

