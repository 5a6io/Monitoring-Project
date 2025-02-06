package com.example.demo.question;

import java.io.Serializable;

public class QuestionResponse implements Serializable {
    int code;
    private String message;

    public QuestionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
