package net.movingjin.api.lambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ConsumerTest {
    @Test
    @DisplayName("Consumer Test")
    void accept()
    {
        List<Integer> list = Arrays.asList(1,2,3);
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(5);
        print(list, consumer);

        assertThat(list.get(1), is(equalTo(2)));
    }

    private static <T> void print(List<T> list, Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }
}
