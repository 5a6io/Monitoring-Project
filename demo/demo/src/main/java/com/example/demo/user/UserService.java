package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse saveUser(UserRequestDto userRequestDto) {

        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            log.info("Exists username = {}", userRequestDto.getUsername());
            return new UserResponse(200, "이미 존재하는 회원입니다.");
        } else {
            User user = new User(
                    userRequestDto.getUsername(),
                    passwordEncoder.encode(userRequestDto.getPassword()),
                    userRequestDto.getEmail());
            userRepository.save(user);
            log.info("{}님의 정보가 등록되었습니다.", user.getUsername());
            return new UserResponse(200, "회원 정보가 저장되었습니다.");
        }
    }

    public UserResponse login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (!user.getEmail().equals(email) || !user.getPassword().equals(passwordEncoder.encode(password))) {
            return new UserResponse(200, "이메일 혹은 비밀번호가 잘못되었습니다.");
        }

        return new UserResponse(200, "로그인 성공");
    }
}