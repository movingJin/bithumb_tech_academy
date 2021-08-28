package net.movingjin.api.methodReference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ConstructorReferenceTest {
    @Test
    @DisplayName("Constructor 테스트")
    void apply(){
        /*
        Thread t = new Thread();    //선언형 방식, 자원과리가 어려움 지양
        Thread t2 = new Thread();
         */
        Function<Runnable, Thread> function = Thread::new;  // 팩토리 방식, 지향
        function.apply(() -> System.out.println("Test Execute1"))
                .start();
        function.apply(() -> System.out.println("Test Execute2"))   //lambda 중간까지는 Function으로 정의하며(입력과 리턴이 있어야 하므로),
                .start();   //마지막은 반드시 Consumer로 끝나야 한다.
    }
}
