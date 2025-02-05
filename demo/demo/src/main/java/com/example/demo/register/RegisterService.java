package com.example.demo.register;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterService {
    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);
    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public RegisterResponse registerUser(RegisterRequestDto registerRequestDto) {

        if (registerRepository.existsById(registerRequestDto.getUsername())) {
            log.info("Exists User = {}", registerRequestDto.getUsername());
            return new RegisterResponse(200, "이미 존재하는 회원입니다.");
        } else {
            User user = new User(
                    registerRequestDto.getUsername(),
                    registerRequestDto.getPassword(),
                    registerRequestDto.getEmail());
            registerRepository.save(user);
            return new RegisterResponse(200, "회원 정보가 저장되었습니다.");
        }
    }
}