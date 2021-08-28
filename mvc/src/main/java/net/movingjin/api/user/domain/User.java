package net.movingjin.api.user.domain;

import lombok.Data;
import net.movingjin.api.order.domain.Order;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User { //보안을 위해 분리시켜 둠(DB용)
    @Id @Column(name = "user_id")
    private long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 8, message = "8자리 이상 입력하세요.")
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "reg_date")
    private String regDate;

    @OneToMany(mappedBy = "user")   //Order에 있는 user 멤버 변수와 연결
    private List<Order> orders = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;
}
