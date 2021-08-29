package net.movingjin.api.user.service;

import net.movingjin.api.item.domain.Item;
import net.movingjin.api.user.domain.User;
import net.movingjin.api.user.domain.UserDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    boolean existsByUsername(String username);
    List<User> findAll();
    Optional<User> findByUsername(String username);   //있을수도 없을 수도 있으면 find
    UserDto signin(User user);
    String signup(User user);
    //Dto 는 FE 로 전달, Entity 는 DB 로 전달하는 도메인 객체이다. (보안을 위해 저장공간(객체))를 분리
    User getById(long id);  //반드시 있는건 get
    void save(User user);
    int count();
    void deleteById(long id);
}
