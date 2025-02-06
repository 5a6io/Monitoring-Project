package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Validated UserRequestDto userRequestDto) {
        UserResponse userResponse = userService.saveUser(userRequestDto);

        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestParam @Validated String email, @RequestParam @Validated String password) {

        UserResponse userResponse = userService.login(email, password);

        return ResponseEntity.ok().body(userResponse);
    }
}
