package com.movingjin.api.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ConsumerApplication {
	private final PollableChannel channel;

	public static void main(String[] args)
	{
		SpringApplication.run(ConsumerApplication.class, args);
//		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConsumerApplication.class).run(args);
//		context.getBean(ConsumerApplication.class).run(context,"QUIZ-SHOW");
	}

	private void run(ConfigurableApplicationContext context, String s) {
		log.info("###########################ConsumerApplication Start###############################");
		PollableChannel channel = context.getBean("messageChannel", PollableChannel.class);
		Message<?> received = channel.receive();
		while(received != null ){
			received = channel.receive();
			log.info("Received: " + received.getPayload());
		}
		log.info("###############################Consumer Closed#############################################");
	}
}
