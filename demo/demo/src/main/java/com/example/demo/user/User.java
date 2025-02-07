package com.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false, length = 15)
    private String password;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}