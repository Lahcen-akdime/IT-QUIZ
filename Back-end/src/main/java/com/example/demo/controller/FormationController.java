package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationRepository;

@RestController
public class FormationController {

    @Autowired
    private FormationRepository formationRepository ;
    
    @GetMapping("/formations")
    public List<Formation> getFormations(){
        return formationRepository.findAll() ;
    }
}
