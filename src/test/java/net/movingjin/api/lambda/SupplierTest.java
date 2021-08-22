package net.movingjin.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SupplierTest {
    @Test
    @DisplayName("Supplier Test")
    void get(){
        Supplier<String> stringSupplier = () -> new String("No pain, No gain");
        String result = stringSupplier.get();
        assertThat(result, is(equalTo("No pain, No gain")));

        Supplier<Double> doubleSupplier = Math::random;  //선언, 리턴이 단 하나이면서 parameter가 없는 경우 ::으로 표현가능
        Double random = doubleSupplier.get();   //실행
        System.out.println(random);
    }
}
