package net.movingjin.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BiFunctionTest {
    @Test
    @DisplayName("BiFunction 테스트")
    void apply(){
        BiFunction<String, String, Integer> biFunction = (a, b)-> a.length() + b.length();
        assertThat(biFunction.apply("Hello", "Lee"), is(equalTo(8)));
    }
}
