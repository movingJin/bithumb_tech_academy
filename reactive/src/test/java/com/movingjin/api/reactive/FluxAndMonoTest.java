package com.movingjin.api.reactive;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import com.movingjin.api.reactive.config.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class FluxAndMonoTest {
    @Mock CustomException customExceptionMono;  //0 to 1
    @Mock CustomException customExceptionFlux;  //0 to N

    @BeforeEach
    void setUp(){
        customExceptionMono = new CustomException("Mono");
        customExceptionFlux = new CustomException("Flux");
    }

    @Test
    @DisplayName("Flux just() Sample")
    void justTest(){
        List<String> names = new ArrayList<>();
        Flux<String> flux = Flux.just("김구", "윤봉길", "유관순", "김좌진").log();     //String인경우, just사용
        flux.subscribe(names::add);  //flux는 구독을해야 작동
        assertThat(names, is(equalTo(Arrays.asList("김구", "윤봉길", "유관순", "김좌진"))));
    }

    @Test
    @DisplayName("Flux range() Sample")
    void rangeTest(){
        List<Integer> list = new ArrayList<>();
        Flux<Integer> flux = Flux.range(1, 5).log();
        flux.subscribe(list::add);  //flux는 구독을해야 작동
        assertThat(list.size(), is(5));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(6));
    }

    @Test
    @DisplayName("Flux fromArray() Sample")
    void fromArrayTest(){
        List<String> list = new ArrayList<>();
        Flux<String> flux = Flux.fromArray(new String[] {"김구", "윤봉길", "유관순", "김좌진"} ).log();
        flux.subscribe(list::add);  //flux는 구독을해야 작동
        assertThat(list, is(equalTo(Arrays.asList("김구", "윤봉길", "유관순", "김좌진"))));
    }

    @Test
    @DisplayName("Flux fromStream() Sample")
    void fromStreamTest(){
        List<String> list = new ArrayList<>();
        Flux<String> flux = Flux.fromStream(Arrays.asList("김구", "윤봉길", "유관순", "김좌진").stream()).log();
        flux.subscribe(list::add);  //flux는 구독을해야 작동
        assertThat(list, is(equalTo(Arrays.asList("김구", "윤봉길", "유관순", "김좌진"))));
    }


    @Test
    @DisplayName("Flux generator() Sample")
    void generatorTest(){
        Flux<String> flux = Flux.generate(
                ()->{return 0;},
                (state,sink)->{sink.next("3 *" + state + " = "+state);
                    if(state == 10){
                        sink.complete();
                    }
                    return state + 1;
                });
            flux.subscribe((System.out::println));
    }

    /**
     * Flux.create()와 배압
     * Subscriber로부터 요청이 왔을 때(FluxSink#onRequest) 데이터를 전송하거나(pull 방식)
     * Subscriber의 요청에 상관없이 데이터를 전송하거나(push 방식)
     * 두 방식 모두 Subscriber가 요청한 개수보다 더 많은 데이터를 발생할 수 있다.
     * 이 코드는 Subscriber가 요청한 개수보다 3개 데이터를 더 발생한다. 이 경우 어떻게 될까?
     * 기본적으로 Flux.create()로 생성한 Flux는 초과로 발생한 데이터를 버퍼에 보관한다.
     * 버퍼에 보관된 데이터는 다음에 Subscriber가 데이터를 요청할 때 전달된다.
     * 요청보다 발생한 데이터가 많을 때 선택할 수 있는 처리 방식은 다음과 같다.
     * IGNORE : Subscriber의 요청 무시하고 발생(Subscriber의 큐가 다 차면 IllegalStateException 발생)
     * ERROR : 익셉션(IllegalStateException) 발생
     * DROP : Subscriber가 데이터를 받을 준비가 안 되어 있으면 데이터 발생 누락
     * LATEST : 마지막 신호만 Subscriber에 전달
     * BUFFER : 버퍼에 저장했다가 Subscriber 요청시 전달. 버퍼 제한이 없으므로 OutOfMemoryError 발생 가능
     * Flux.create()의 두 번째 인자로 처리 방식을 전달하면 된다.
     * */
    @Test
    @DisplayName("Flux create() Sample")
    void createTest(){
        Flux<Integer> flux = Flux.create((FluxSink<Integer> sink) -> {  //state는 상태, sink는 이벤트
            sink.onRequest(request -> {
                for(int i=0; i<request+3; i++){ //lambda 안에선 기존코드를 사용해도 됨. 끝나면 사라지기 때문
                    sink.next(i);
                }
            });
        });
        flux.subscribe(System.out::println);
    }

    @Test
    @DisplayName("Flux empty() Sample")
    void emptyTest(){
        List<String> list = new ArrayList<>();
        Flux<String> flux = Flux.empty();
        flux.subscribe(list::add);
        assertThat(list.size(), is(0));
    }

    @Test
    @DisplayName("Mono just() Sample")
    void monojustTest(){
        /**
         * Reactive Stream 에서는 Data, Event, Signal 중에서 Signal 을 사용한다.
         * onNext, onComplete, onError
         * */
        List<Signal <Integer>> list = new ArrayList<>();
        final Integer[] result = new Integer[1];
        Mono<Integer> mono = Mono.just(1).log()
                .doOnEach(i -> {
                    list.add(i);
                    System.out.println("Signal: " + i);
                });
        mono.subscribe(i -> result[0] = i);
        assertThat(list.size(), is(2));
        assertThat(list.get(0).getType().name(), is(equalTo("ON_NEXT")));
        assertThat(list.get(1).getType().name(), is(equalTo("ON_COMPLETE")));
        assertThat(result[0].intValue(), is(1));
    }


    @Test
    @DisplayName("Mono empty() Sample")
    void monoEmptyTest(){
        Mono<String> mono = Mono.empty();
        assertThat(mono.block(), is(nullValue()));
    }

    @Test
    @DisplayName("Mono empty just() Sample")
    void monoEmptyJustTest(){
        Mono.empty().subscribe(System.out::println);    //System.out::println이 들어가면 block, product코드에선 subscribe 함수 내에서 반드시 빼야함.
        Mono.just("Java")
                .map(item -> "Mono Item : " + item)
                .subscribe(System.out::println);

        System.out.println();
        Flux.empty().subscribe(System.out::println);
        Flux.just("Java", "Oracle", "Python")
                .map(item -> item.toUpperCase())
                .subscribe(System.out::println);
    }

    @Test @DisplayName("Mono Flux error() Sample")
    void errorTest(){
        Mono.error((Supplier<? extends Throwable>) customExceptionMono)
                .doOnError(e -> System.out.println("Mono inside doOnError"))
                .subscribe(System.out::print);
        Flux.error((Supplier<? extends Throwable>) customExceptionFlux)
                .doOnError(e -> System.out.println("Flux inside doOnError"))
                .subscribe(System.out::print);
    }
}
