package com.movingjin.api.kafka.service;

import com.movingjin.api.kafka.domain.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
    private final GeneratorService service;

    @Override
    //public Mono<Quiz> creteQuiz() {
    public Quiz creteQuiz() {
        int factorA = service.randomFactor();
        int factorB = service.randomFactor();
        Quiz quiz = new Quiz(factorA, factorB);
        //return Mono.just(quiz);
        return quiz;
    }

    @Override
    public List<Quiz> getQuizzes() {
        List<Quiz> list = new ArrayList<>();
        list.add(creteQuiz());
        list.add(creteQuiz());
        list.add(creteQuiz());
        list.add(creteQuiz());
        list.add(creteQuiz());
        list.add(creteQuiz());
        return list;
    }
}