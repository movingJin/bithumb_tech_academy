package net.movingjin.api.lambda;

import java.util.List;
import java.util.function.Consumer;

public class Test {

    <T> void print(List<T> list, Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }
}
