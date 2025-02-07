package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

    @Autowired
    private UserRepository repository;

    @Test
    void saveUser() {
        //given
        User user = new User();
        user.setEmail("test@naver.com");
        user.setUsername("Lucy");
        user.setPassword("test1234");

        //when
        repository.save(user);
        User findUser = repository.findByEmail(user.getEmail());

        //then
        assertThat(findUser.getUsername()).isEqualTo("Lucy");
    }

    @Test
    void login() {
        //given
        User user = new User();
        user.setEmail("test@naver.com");
        user.setUsername("Lucy");
        user.setPassword("test1234");

        //when
        repository.save(user);
        User findUser = repository.findByEmail(user.getEmail());

        //then
        assertThat(findUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(findUser.getPassword()).isEqualTo(user.getPassword());
    }
}