package com.example.demo.question;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/save")
    public ResponseEntity<QuestionResponse> saveQuestion(@RequestBody @Validated QuestionRequestDto questionRequestDto) {

        QuestionResponse questionResponse = questionService.saveQuestion(questionRequestDto);

        return ResponseEntity.ok().body(questionResponse);
    }
}
