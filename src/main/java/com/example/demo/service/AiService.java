package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.repository.InformationRepository;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class AiService {

  @Autowired
  private com.example.demo.config.ApiKeyConfig ApiKeyConfig ;
  
  @Autowired
  private InformationRepository informationRepository ;
  
  public String askAi() { 
    Client client = Client.builder().apiKey(ApiKeyConfig.getApiKey()).build();
    GenerateContentResponse response =
        client.models.generateContent(
            "gemini-2.5-flash",
            "Give me a quiz of 10 questions for this informations "
            +this.getAllInformationText().toString()+
            "(in json format , respecting this structure of each question : {questions[] each question : {question , " +
            ", options[] , {correct answer : index of the correct option} }}) , "+
            "Return ONLY valid JSON. " +
            "Do not use markdown. " + 
            "Do not use code fences. " +
            "Do not write explanations. " +
            "Do not write ```json. " + 
            "The response must begin with { and end with }." ,
            null);
          return response.candidates().get().get(0)
          .content().get()
          .parts().get().get(0)
          .text().get() ;
  }


  public List<String> getAllInformationText() {
      return informationRepository.getAllInformationText() ;
  }

  
}