package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.QuizDTO;
import com.example.demo.service.AiService;
import com.example.demo.service.QuizSaverService;

import tools.jackson.databind.ObjectMapper;


@RestController
public class TestController {

    @Autowired
    private AiService aiService ;

    @Autowired
    private QuizSaverService quizSaverService ;

    @Autowired
    private ObjectMapper objectMapper ;

    @RequestMapping("/test")
    public Boolean test() throws Exception {

        // String response =  aiService.askAi() ;
        // QuizDTO quizDTO = objectMapper.readValue(response, QuizDTO.class) ;
        // Boolean resault = quizSaverService.SaveQuiz(quizDTO, 1L) ;
        // return resault ;

        return true ;
    }
}
