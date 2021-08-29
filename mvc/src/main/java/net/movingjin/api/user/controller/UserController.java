package net.movingjin.api.user.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import net.movingjin.api.user.domain.User;
import net.movingjin.api.user.domain.UserDto;
import net.movingjin.api.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
//요즘엔 백과 프론트서버를 물리적으로 나누므로 CORS 설정이 필요함
@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    @ApiOperation(value="${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code=400, message = "Something Wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 ID")
    })
    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                             @RequestBody UserDto userDto){ //Front 쪽에 Entity를 노출시키면 안됨
        System.out.println("회원가입 정보" + userDto.toString());
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value="${UserController.signin}")
    @ApiResponses(value = {
            @ApiResponse(code=400, message = "Something Wrong"),
            @ApiResponse(code=422, message = "유효하지 않은 아이디 혹은 비밀번호")
    })
    public ResponseEntity<UserDto> signin(@ApiParam("Signin User")
                                             @RequestBody UserDto userDto){
        System.out.println("로그인 정보" + userDto.toString());
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }

//    @GetMapping
//    public List<User> findAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<User> findByUsername(@PathVariable String username) {
//        return userService.findByUsername(username);
//    }
//
//    @GetMapping("/exists")
//    public boolean existsByUsername(String username) {
//        return userService.existsByUsername(username);
//    }
//
//    @GetMapping("/count")
//    public int count() {
//        return userService.count();
//    }
//
//    @PostMapping
//    public void save(@RequestBody User entity) {
//        userService.save(entity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable long id) {
//        userService.deleteById(id);
//    }
}
