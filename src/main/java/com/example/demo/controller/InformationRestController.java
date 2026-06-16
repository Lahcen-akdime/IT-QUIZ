package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.InformationRepository;


@Controller
@RequestMapping("/api/v1/informations")

public class InformationRestController {
    @Autowired
    private InformationRepository informationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAllInformation(){
        return this.informationRepository.getAllInformationText() ;
    }

    public void run() {
        List<String> texts = informationRepository.getAllInformationText() ;
    
        for (String text : texts) {
            System.out.println(text);
        }
        
    }

}
