package com.example.demo.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Getter
public class Question {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qid;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String username;

    @Setter
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
