package net.movingjin.api.user.controller;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.user.domain.User;
import net.movingjin.api.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/exists")
    public boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }

    @GetMapping("/count")
    public int count() {
        return userService.count();
    }

    @PostMapping
    public void save(@RequestBody User entity) {
        userService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }
}
