package com.example.demo.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionServiceTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    void saveQuestion() {
        // given
        Question q = new Question();
        q.setEmail("test@naver.com");
        q.setUsername("Lucy");
        q.setQuestion("테스트는 성공인가요?");

        //when
        repository.save(q);
        Optional<Question> questions = repository.findByUsernameAndQuestion(q.getUsername(), q.getQuestion());

        //then
        assertThat(questions).isPresent();
        assertThat(questions.get().getQuestion()).isEqualTo("테스트는 성공인가요?");
    }
}