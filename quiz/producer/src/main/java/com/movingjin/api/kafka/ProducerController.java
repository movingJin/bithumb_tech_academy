package com.movingjin.api.kafka;

import com.movingjin.api.kafka.domain.Quiz;
import com.movingjin.api.kafka.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class ProducerController {
    //private final ProducerComponent producer;
    private final QuizService quizService;

    @GetMapping
    public String home()
    {
        return "Hello Kafka";
    }

//    @PostMapping
//    public String sendMessage(@RequestParam("message") String message){
//        System.out.println("################### send message 진입 ####################");
//        this.producer.sendMessage(message);
//        return "Kafka Successfully";
//    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes()
    {
        return quizService.getQuizzes();
    }
}
