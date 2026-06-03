package com.example.demo.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class AiService {
  public static void main(String[] args) {
     Client client = Client.builder().apiKey(System.getenv("GEMINI_API_KEY")).build();

    GenerateContentResponse response =
        client.models.generateContent(
            "gemini-2.5-flash",
            "Explain how AI works in a 10 words",
            null);

    System.out.println(response.text());
  }
  
}