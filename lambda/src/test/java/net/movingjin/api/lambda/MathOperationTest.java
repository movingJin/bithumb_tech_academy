package net.movingjin.api.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
class MathOperationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("TDD Function 테스트")
    void apply() {
        MathOperation mathOperation = (a, b)-> a + b;
        int result = mathOperation.apply(1, 8);
        assertThat(result, is(equalTo(9)));
    }
}