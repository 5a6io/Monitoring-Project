package com.example.demo.user;

import com.example.demo.user.jwt.JwtToken;
import com.example.demo.user.jwt.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

    @Autowired
    private UserRepository repository;

    /**
     * Mockito 기반 테스트
     * Mockito라는 테스트 라이브러리를 사용하여 단위 테스트를 작성하는 방법.
     * Mockito는 Java에서 객체를 모킹할 수 있는 프레임워크로, 테스트할 때 실제 객체 대신 가짜 객체를 만들어서 의존성 주입을 대신하는 방식입니다.
     * 이를 통해 독립적이고, 외부 시스템과의 의존성을 최소화하여 빠르고 효율적인 테스트를 할 수 있다.
     * Mockito 핵심 개념
     * 1. Mock: 실제 객체 대신 사용할 가짜 객체입니다. 이를 통해 외부 시스템이나 서비스와의 상호작용 없이 테스트를 할 수 있습니다. 예를 들어, 데이터베이스 호출이나 외부 API 요청 없이 로직을 테스트할 수 있습니다.
     * 2. Stub: 메서드 호출에 대해 미리 정의된 반환값을 설정할 수 있습니다. 테스트 중에 특정 메서드를 호출하면 예상되는 값을 반환하도록 설정할 수 있습니다.
     * 3. Spy: 실제 객체의 메서드를 호출하면서 일부 메서드만 스텁하거나 모킹할 수 있습니다. 기존의 객체를 일부 수정하여 사용할 수 있는 방식입니다.
     * 4. Verify: 특정 메서드가 호출되었는지, 또는 몇 번 호출되었는지를 확인할 수 있습니다. 이를 통해 특정 로직이 실행되는지 확인할 수 있습니다.
     */

    @Test
    void saveUser() {
        //given
        User user = new User();
        user.setEmail("test@naver.com");
        user.setUsername("Lucy");
        user.setPassword("test1234");
        user.setRole("ROLE_USER");

        //when
        repository.save(user);
        Optional<User> findUser = repository.findByEmail(user.getEmail());

        //then
        assertThat(findUser.get().getUsername()).isEqualTo("Lucy");
    }
}