package net.movingjin.api.user.service;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.security.domain.SecurityProvider;
import net.movingjin.api.security.exception.SecurityRuntimeException;
import net.movingjin.api.user.domain.Role;
import net.movingjin.api.user.domain.User;
import net.movingjin.api.user.domain.UserDto;
import net.movingjin.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final SecurityProvider securityProvider;
    private final ModelMapper modelMapper;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto signin(User user) {
        try{
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = (encoder.matches(user.getPassword(),
                    userRepository.findByUsername(user.getUsername()).get().getPassword()))
                    ? securityProvider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password";
            userDto.setToken(token);
            userDto.setName(userRepository.findByUsername(user.getName()).get().getName());
            userDto.setEmail(userRepository.findByUsername(user.getName()).get().getEmail());
            userDto.setUserId(userRepository.findByUsername(user.getName()).get().getUserId());
            return userDto;
        }
        catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String signup(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(encoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            return securityProvider.createToken(user.getUsername(), user.getRoles());
        }
        else{
            throw new SecurityRuntimeException("중복된 ID 입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public int count() {
        return (int)userRepository.count();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
