package net.movingjin.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UnaryOperationTest {
    @Test
    @DisplayName("단항식 테스트")
    void apply(){
        List list = Arrays.asList(10, 20, 30, 40, 50);
        UnaryOperator<Integer> unaryOperator = integer -> integer * 10;
        int result = unaryOperator.apply((Integer) list.get(2));
        assertThat(result, is(equalTo(300)));

        List<Integer> ret = map(list, unaryOperator);
    }

    private static <T> List<T> map(List<T> list, UnaryOperator<T> unaryOperator) {
        List<T> l = new ArrayList<>();
        for(T item: list){

        }
        return l;
    }


}
