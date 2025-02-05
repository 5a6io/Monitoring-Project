package com.example.demo.register;

import java.io.Serializable;


public class RegisterResponse implements Serializable {
    int code;
    private String message;

    public RegisterResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
