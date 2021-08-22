package net.movingjin.api.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MyFunctionalInterfaceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Functional Interface Test")
    void myMethod() {
        MyFunctionalInterface fun = () -> "Hello Function Interface Interface";
        assertThat(fun.myMethod(), is(equalTo("Hello Function Interface Interface")));
    }

    @Test
    @DisplayName("Imperative vs Delarative")
    void main() {
        int sumOfEvens = 0;
        //Imperative
        for(int u=0; u<101; u++){
            if(u%2 == 0){
                sumOfEvens += u;
            }
        }
        System.out.println("Imperative sumOfEvens is " + sumOfEvens);

        //Declarative
        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2==0)
                .reduce((x,y) -> x+y)
                .getAsInt();
        System.out.println("Declarative sumOfEvens is " + sumOfEvens);
    }


}