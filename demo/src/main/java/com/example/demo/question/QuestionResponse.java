package com.example.demo.question;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse implements Serializable {
    @JsonInclude
    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String question;

    public QuestionResponse(String message) {
        this.message = message;
    }
}
