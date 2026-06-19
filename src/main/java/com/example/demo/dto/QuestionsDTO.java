package com.example.demo.dto;

public class QuestionsDTO {

    private String question ;
    private String[] options ;
    private Integer correct_answer ;
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

    public void setOptions(String[] options){
        this.options = options ;
    }

    public void setCorrect_answer_index(int correct_answer){
        this.correct_answer = correct_answer ;
    }

    
}
