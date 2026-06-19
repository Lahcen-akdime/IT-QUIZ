package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Question;

public interface questionRepository extends JpaRepository<Question,Integer>{
    
}
