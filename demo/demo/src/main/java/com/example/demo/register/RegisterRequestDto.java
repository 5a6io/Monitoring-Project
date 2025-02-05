package com.example.demo.register;

public class RegisterRequestDto {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private String username;

    private String password;

    private String email;
}
