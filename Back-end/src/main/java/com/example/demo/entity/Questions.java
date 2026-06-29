package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NonNull;

@Entity
public class Questions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @NonNull
    private String question ;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation ;

    public Questions(){

    }

    public Questions(String question , Formation formation){
        this.question = question ;
        this.formation = formation ;
    }

    public int getId(){
        return id ;
    }

    public String getQuestion(){
        return question ;
    }

    public Formation getFormation(){
        return formation ;
    }

    public void setId(int id){
        this.id = id ;
    }

    public void setQuestion(String question){
        this.question = question ;
    }

    public void setFormation(Formation formation){
        this.formation = formation ;
    }

    public String toString(){
        return "Question [id=" + id + ", question=" + question + ", formation=" + formation + "]";
    }

}
