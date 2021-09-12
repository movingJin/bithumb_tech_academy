package com.movingjin.api.kafka.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializable;

import com.movingjin.api.kafka.domain.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MyProducerConfig {
//    @Value("${spring.kafka.bootstrap-servers}") //aaplication.yml의 값을 가져옴
//    private String bootStrapServers;

//    @Bean
//    public DirectChannel producerChannel(){
//        return new DirectChannel();
//    }

    @Bean
    public ProducerFactory producerFactory(){
        Map<String, Object> properties = new HashMap<>();
        //properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        return new DefaultKafkaProducerFactory(properties);
    }
    @Bean
    public KafkaTemplate<String, User> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    @ServiceActivator(inputChannel = "messageChannel")
//    public MessageHandler kafkaMessageHandler(){
//        KafkaProducerMessageHandler<String, String> handler = new KafkaProducerMessageHandler<>(kafkaTemplate());
//        handler.setMessageKeyExpression(new LiteralExpression("kafka-integration"));
//        return handler;
//    }
}
