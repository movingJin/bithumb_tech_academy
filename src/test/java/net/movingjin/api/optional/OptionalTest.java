package net.movingjin.api.optional;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OptionalTest {
    @Data class Order {
        private final Long id;
        private final Date date;
        private final Member member;
    }
    @Data class Member {
        private final Long id;
        private final String name;
        private final Address address;
    }

    @Data class Address {
        private final String street;
        private final String city;
        private final String zipcode;
    }

    /* 주문을 한 회원이 사는 도시는?*/
    public String getCityOfMemberFromOrder(Order order){
        return Optional.ofNullable(order)
                .map(Order::getMember)  //한 요소요소마다 점검하는 기능
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("No Address");
    }   //NULL이 아닌, 빈 값인 경우

    /* 주어진 시간(분) 내에 생성된 주물을 한 회원정보는? */
    public Optional<Member> getMemberOrderWithin(Order order, int min){
        return Optional.ofNullable(order)
                .filter(o -> o.getDate().getTime() > System.currentTimeMillis() - min * 1000)
                .map(Order::getMember);
    }

    @Test
    @DisplayName("")
    void apply(){

    }
}
