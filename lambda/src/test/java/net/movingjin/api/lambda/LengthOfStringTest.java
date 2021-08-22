package net.movingjin.api.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LengthOfStringTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("String의 길이 변환 테스트")
    void apply() {
        LengthOfString lengthOfString = str -> str.length();    //선언 - param이 없을시, ()->
        int result = lengthOfString.apply("apple"); //실행
        assertThat(result, is(equalTo(5))); //테스트
    }
}