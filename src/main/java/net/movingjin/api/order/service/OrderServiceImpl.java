package net.movingjin.api.order.service;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.order.domain.Order;
import net.movingjin.api.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int)orderRepository.count();
    }

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }
}
