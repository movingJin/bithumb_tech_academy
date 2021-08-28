package net.movingjin.api.user.service;

import net.movingjin.api.item.domain.Item;
import net.movingjin.api.user.domain.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    boolean existsByUsername(String username);
    List<User> findAll();
    Optional<User> findByUsername(String username);   //있을수도 없을 수도 있으면 find
    User signin(String user, String password);
    User getById(long id);  //반드시 있는건 get
    void save(User user);
    int count();
    void deleteById(long id);
}
