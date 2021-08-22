package net.movingjin.api.stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class StreamTest {
    @Test
    @DisplayName("Stream 테스트")
    void apply() {
        //List<String> s = Arrays.asList("Appli", "Orange", ""); //Blocking 방식
        Stream<String> s = Arrays.asList("Appli", "Orange", "").stream(); //NonBlocking 방식
        int emptyStrings = (int) s.filter(String::isEmpty).count();
        assertThat(emptyStrings, is(equalTo(1)));
    }
}
