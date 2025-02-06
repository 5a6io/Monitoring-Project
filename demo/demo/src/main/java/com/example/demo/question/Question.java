package com.example.demo.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Getter
public class Question {
    @Id
    @Column(name = "q_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String listId;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String question;

    @Column(name = "date", updatable = false)
    @CreationTimestamp
    private LocalDateTime date;

    public Question(String email, String username, String question) {
        this.email = email;
        this.username = username;
        this.question = question;
    }
}
