package net.movingjin.api.order.controller;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.order.domain.Order;
import net.movingjin.api.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final  OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @GetMapping("/exists")
    public boolean existsById(long id) {
        return orderService.existsById(id);
    }

    @GetMapping("/count")
    public int count() {
        return orderService.count();
    }

    @PostMapping
    public void save(@RequestBody Order entity) {
        orderService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        orderService.deleteById(id);
    }
}
