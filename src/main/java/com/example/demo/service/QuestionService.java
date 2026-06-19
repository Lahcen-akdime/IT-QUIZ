package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Question;
import com.example.demo.repository.questionRepository;

public class QuestionService {

    @Autowired
    private questionRepository questionRepository;

    public List<Question> SaveQuestionService(List<Question> questions) {
        for(Question question : questions){
            questionRepository.save(question);
        }
        return questions;
    }
    
}
