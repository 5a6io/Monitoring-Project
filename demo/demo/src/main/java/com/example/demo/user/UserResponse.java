package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor()
@AllArgsConstructor()
public class UserResponse implements Serializable {
    @JsonInclude
    private String message;
    @JsonInclude
    private String token;

    public UserResponse(String message) {
        this.message = message;
    }
}
