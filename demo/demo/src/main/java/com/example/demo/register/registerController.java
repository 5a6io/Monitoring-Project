package com.example.demo.register;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class registerController {
    private final RegisterService registerService;

    public registerController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody @Validated RegisterRequestDto registerRequestDto) {
        RegisterResponse registerResponse = registerService.registerUser(registerRequestDto);

        return ResponseEntity.ok().body(registerResponse);
    }
}
