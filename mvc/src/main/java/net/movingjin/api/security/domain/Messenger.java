package net.movingjin.api.security.domain;

import lombok.Builder;
import lombok.Getter;

@Getter //Security는 Setter를 쓰는 일이 없다.
@Builder
public class Messenger {
    private String message;
    private int status;
    private String code;
}
