package net.movingjin.api.methodReference;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lombok.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class EnumTest {

    @RequiredArgsConstructor
    enum Operation{
        PLUS("+", (x,y)-> x+y),
        MINUS("-", (x,y)-> x-y),
        TIMES("*", (x,y)-> x*y),
        DIVIDE("/", (x,y)-> x/y);

        private final String symbol;
        private final DoubleBinaryOperator operator;

        @Override public String toString(){return symbol;}
        public double apply(double x, double y){return operator.applyAsDouble(x,y);}
    }

    @Test
    @DisplayName("Enum 테스트")
    void apply(){
        assertThat(Operation.PLUS.apply(5,7), is(equalTo(12.0)));
        assertThat(Operation.MINUS.apply(5,7), is(equalTo(-2.0)));
        assertThat(Operation.TIMES.apply(5,7), is(equalTo(35.0)));
        assertThat(Operation.DIVIDE.apply(14,7), is(equalTo(2.0)));
    }

}
