package com.example.demo.entity;

// import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NonNull;
import lombok.Builder.Default;

@Entity
public class Option {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @NonNull
    private String option ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;

    private Boolean is_correct = false;

}
