package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Validated SaveRequestDto saveRequestDto) {
        UserResponse userResponse = userService.saveUser(saveRequestDto);

        return ResponseEntity.ok().body(userResponse);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponse> login(@RequestBody @Validated LoginRequestDto loginRequestDto) {

        UserResponse userResponse = userService.login(loginRequestDto);

        return ResponseEntity.ok().body(userResponse);
    }
}
