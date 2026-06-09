package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "informations")
public class Information {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String text ;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation ;
}
