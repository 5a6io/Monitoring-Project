package com.example.demo.user;

import java.io.Serializable;


public class UserResponse implements Serializable {
    int code;
    private String message;

    public UserResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
