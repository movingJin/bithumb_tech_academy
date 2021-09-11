package com.movingjin.api.kafka.service;

import com.movingjin.api.kafka.domain.Quiz;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface QuizService {
    //public Mono<Quiz> creteQuiz();
    Quiz creteQuiz();
    List<Quiz> getQuizzes();
}