package net.movingjin.api.methodReference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MethodReferenceTest {
    class MethodReferenceClass{
        Supplier<Date> newDate = Date::new; //MethodReference는 파라미터가 없는 lambda
        Supplier<Double> doubleRandom = Math::random;
        Consumer<String> print = System.out::print;
        Function<Object, String> objectToString = String::valueOf;
        Function<String, Integer> stringToInteger = Integer::parseInt;
        Function<Double, Double> doubleAbs = Math::abs;
        Function<Float, Float> floatAbs = Math::abs;
        Function<Integer, Integer> integerAbs = Math::abs;
        Function<Long, Long> longAbs = Math::abs;
        Function<Double, Double> doubleCeil = Math::ceil;
        Function<Double, Double> doubleFloor = Math::floor;
        Function<Double, Double> doubleRint = Math::rint;
        Function<Double, Long> doubleRound = Math::round;
        Function<Float, Integer> floatRound = Math::round;
        BiFunction<Double, Double, Double> doubleMax = Math::max;
        BiFunction<Float, Float, Float> floatMax = Math::max;
        BiFunction<Integer, Integer, Integer> integerMax = Math::max;
        BiFunction<Long, Long, Long> longMax = Math::max;
        BiFunction<Double, Double, Double> doubleMin = Math::min;
        BiFunction<Float, Float, Float> floatMin = Math::min;
        BiFunction<Integer, Integer, Integer> integerMin = Math::min;
        BiFunction<Long, Long, Long> longMin = Math::min;
        BiFunction<Integer, Integer, Integer> rangeUnderRandom = (t, u) -> (int) (Math.random() * (u - t)) + t;
        BiFunction<Integer, Integer, Integer> rangeBelowRandom = (t, u) -> (int) (Math.random() * u) + t;
    }

    @Test
    @DisplayName("MethodReferenceClass 테스트")
    void apply(){
        Function<String, Integer> function = s -> Integer.parseInt(s);
        assertThat(function.apply("45"), is(equalTo(45)));
    }
}
