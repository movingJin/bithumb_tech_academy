package net.movingjin.api.order.service;

import net.movingjin.api.item.domain.Item;
import net.movingjin.api.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(long id);
    boolean existsById(long id);
    int count();
    void save(Order entity);
    void deleteById(long id);
}
