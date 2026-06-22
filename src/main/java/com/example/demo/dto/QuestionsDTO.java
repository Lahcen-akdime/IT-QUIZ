package com.example.demo.dto;

import com.example.demo.entity.Formation;

public class QuestionsDTO {

    private String question ;
    private String[] options ;
    private Integer correct_answer ;
    private Formation formation ;

    public QuestionsDTO(){
        
    }

    public QuestionsDTO(String question , String[] options , int correct_answer ){
        this.question = question ;
        this.options = options ;
        this.correct_answer = correct_answer ;
    }

    public String getQuestion(){
        return question ;
    }

    public String[] getOptions(){
        return options ;
    }

    public Integer getCorrect_answer(){
        return correct_answer ;
    }

    public void setQuestion(String question){
        this.question = question ;
    }

    public Formation getFormation(){
        return formation ;
    }

    public void setFormation(Formation formation){
        this.formation = formation ;
    }

    public void setOptions(String[] options){
        this.options = options ;
    }

    public void setCorrect_answer(int correct_answer){
        this.correct_answer = correct_answer ;
    }

    
}
