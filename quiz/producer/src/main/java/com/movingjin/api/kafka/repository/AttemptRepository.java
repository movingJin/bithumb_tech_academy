package com.movingjin.api.kafka.repository;

import com.movingjin.api.kafka.domain.Attempt;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface AttemptRepository extends ReactiveMongoRepository<Attempt, String> {
    Optional<Attempt> findByAlias(String alias);
    @Query("{'alias':{$regex: ?0}}")
    Flux<Attempt> findRegexByAlias(String alias); //select * from attempts where alias like %alias%

    @Query("{'alias':{$regex: ?0}}")
    Flux<Attempt> findRegexByAliasWithPage(String alias, Pageable page);

    @Query("{id:?0}")
    Mono<Attempt> findById(String id); // select * from attempts where id = ?

    @Query("{quizNo: ?0}")
    Mono<Attempt> findByQuizNo(int quizNo); //select count(*) from attempts where page = ?

    @Query("{quizNo: {$lt:?0}}")
    Flux<Attempt> findLittleThanQuizNo(int quizNo); //select * from attempts where page < ?

    @Query("{quizNo: {$gte:?0}}")
    Flux<Attempt> findGreaterThanEqualQuizNo(int quizNo); //select * from attempts where page >= ?

    @Query(value = "{alias:?0}", count = true)
    int countQuiz(); //select count(*) from attempts where alias = ?

    @Query(value = "{alias:?0, quizNo:?1}", count = true)
    Mono<Attempt> findByAliasAndQuizNo(String alias, int quizNo); //select * from attempts where alias = ? and quizNo = ?


}
