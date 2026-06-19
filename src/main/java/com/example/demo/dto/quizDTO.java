package com.example.demo.dto;

import java.util.List;


public class QuizDTO {
    
    private List<QuestionsDTO> questions ;

    public QuizDTO(){
        
    }

    public QuizDTO(List<QuestionsDTO> questions){
        this.questions = questions ;
    }

    public List<QuestionsDTO> getQuestions(){
        return questions ;
    }

    public void setQuestions(List<QuestionsDTO> questions){
        this.questions = questions ;
    }
    
}
