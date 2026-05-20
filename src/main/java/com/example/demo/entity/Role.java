package com.example.demo.entity;

import jakarta.persistence.OneToOne;

public class Role {
    @OneToOne
    private User user ;
}
