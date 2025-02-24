package com.example.demo.question;

import com.example.demo.user.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public QuestionService(QuestionRepository questionRepository, JwtTokenProvider jwtTokenProvider) {
        this.questionRepository = questionRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public QuestionResponse saveQuestion(QuestionRequestDto questionRequestDto) {
        if (!jwtTokenProvider.validateToken(questionRequestDto.getToken())) {
            return new QuestionResponse("토큰이 유효하지 않습니다.");
        }

        questionRepository.save(new Question(questionRequestDto.getEmail(), questionRequestDto.getUsername(), questionRequestDto.getQuestion()));

        log.info("'{}' 질문이 등록되었습니다.", questionRequestDto.getQuestion());

        return new QuestionResponse("질문이 등록되었습니다.", questionRequestDto.getQuestion());
    }
}
