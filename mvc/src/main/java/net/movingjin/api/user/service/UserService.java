package net.movingjin.api.user.service;

import net.movingjin.api.item.domain.Item;
import net.movingjin.api.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    boolean existsById(long id);
    int count();
    void save(User entity);
    void deleteById(long id);
}
