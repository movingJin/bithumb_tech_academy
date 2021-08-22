package net.movingjin.api.lambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FunctionTest {
    @Test
    @DisplayName("Function Test")
    void apply(){
        List<String> list = Arrays.asList("BitThumb", "Cooperation", "Market");

        Function<String, Integer> function = String::length;
        int result = function.apply(list.get(1));
        assertThat(result, is(equalTo(11)));

        List<Integer> newLine = map(list, function);
        assertThat(newLine.get(2), is(equalTo(6)));
    }


    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> newList = new ArrayList<>();
        for(T t: list){
            newList.add(function.apply(t));
        }
        return newList;
    }
}
