package com.example.demo.user;

import com.example.demo.user.jwt.JwtToken;
import com.example.demo.user.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public UserResponse saveUser(SaveRequestDto saveRequestDto) {

        if (userRepository.existsByUsername(saveRequestDto.getUsername())) {
            log.info("Exists username = {}", saveRequestDto.getUsername());
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }

        User user = new User(
                saveRequestDto.getUsername(),
                passwordEncoder.encode(saveRequestDto.getPassword()),
                saveRequestDto.getEmail());
        user.setRole("ROLE_USER");
        userRepository.save(user);
        log.info("{}님의 정보가 등록되었습니다.", user.getUsername());
        return new UserResponse("회원 정보가 저장되었습니다.");

    }

    public UserResponse login(LoginRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일이 존재하지 않습니다."));

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword());
        Authentication authentication =authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        return new UserResponse("로그인에 성공했습니다.", jwtToken.getAccessToken());
    }
}