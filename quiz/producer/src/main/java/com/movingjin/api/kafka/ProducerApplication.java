package com.movingjin.api.kafka;

import com.movingjin.api.kafka.domain.Quiz;
import com.movingjin.api.kafka.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class ProducerApplication {
	private final QuizService quizService;

	public static void main(String[] args)
	{
//		ConfigurableApplicationContext context = new SpringApplicationBuilder(ProducerApplication.class).run(args);
//		context.getBean(ProducerApplication.class).run(context);
//		context.close();
		SpringApplication.run(ProducerApplication.class, args);
	}

	private void run(ConfigurableApplicationContext context) {
		log.info("###########################ProducerApplication Start###############################");
		MessageChannel channel = context.getBean("messageChannel", MessageChannel.class);
		List<Quiz> quizzes = quizService.getQuizzes();
		for(Quiz quiz: quizzes){
			Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, "QUIZ-SHOW");
			channel.send(new GenericMessage<>(quiz.toString(), headers));
		}
		log.info("###############################Publisher Closed#############################################");
	}

}
