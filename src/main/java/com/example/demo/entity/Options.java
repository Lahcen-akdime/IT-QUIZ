package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NonNull;

@Entity
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @NonNull
    private String option ;

    @ManyToOne

    @JoinColumn(name = "question_id")
    private Questions question ;

    private Boolean is_correct = false;

    public Options(){

    }

    public Options(String option , Questions question , Boolean is_correct){
        this.option = option ;
        this.question = question ;
        this.is_correct = is_correct ;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Questions getQuestion() {
        return this.question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Boolean getIs_correct() {
        return this.is_correct;
    }

    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }

}
