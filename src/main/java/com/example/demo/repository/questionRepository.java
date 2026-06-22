package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions,Integer>{
    
}
