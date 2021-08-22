package net.movingjin.api.user.service;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.user.domain.User;
import net.movingjin.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int)userRepository.count();
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
