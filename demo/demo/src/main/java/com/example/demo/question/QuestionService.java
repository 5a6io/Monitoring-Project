package com.example.demo.question;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionResponse saveQuestion(QuestionRequestDto questionRequestDto) {

        questionRepository.save(new Question(questionRequestDto.getEmail(), questionRequestDto.getUsername(), questionRequestDto.getQuestion()));

        QuestionResponse questionResponse = new QuestionResponse(200, "질문이 등록되었습니다.");
        log.info("'{}' 질문이 등록되었습니다.", questionRequestDto.getQuestion());

        return questionResponse;
    }
}
