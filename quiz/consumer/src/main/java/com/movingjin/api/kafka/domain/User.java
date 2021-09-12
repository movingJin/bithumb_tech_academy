package com.movingjin.api.kafka.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String email;

    @Override
    public  String toString(){
        return String.format("%s,%s,%s\n", id, name, email);
    }
}

