package com.example.demo.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class AiService {
  public static void main(String[] args) {
     Client client = Client.builder().apiKey(System.getenv("GEMINI_API_KEY")).build();

    GenerateContentResponse response =
        client.models.generateContent(
            "gemini-2.5-flash",
            "Give me 10 question of redhat linux (i want your answer in json format) ",
            null);

    System.out.println(response.text());
  }
  
}