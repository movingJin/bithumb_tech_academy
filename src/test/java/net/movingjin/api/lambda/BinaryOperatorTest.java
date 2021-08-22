package net.movingjin.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BinaryOperatorTest {
    @Test
    @DisplayName("BinaryOperator 테스트")
    void apply(){
        BinaryOperator<String> binaryOperator = (a, b)-> a + "." +b;
        String result = binaryOperator.apply("test", "com");
        assertThat(result, is(equalTo("test.com")));
    }
}
