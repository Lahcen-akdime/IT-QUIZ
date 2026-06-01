package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(contact = @Contact(
                            name = "Spring Security JWT" ,
                            email =  "Contact@lahcen.com" ,
                            url = "https://lahcen.com" 
    ),
    description = "OpenApi documentation from spring security project",
    title = "OpenApi specification",
    version = "1.0" ,
    license = @License(
        name = "License name" ,
        url = "https://license.com"
    ),
    termsOfService = "https://lahcen.com/terms"
    ),
    servers = {
        @Server()
    }
)
public class OpenApiConfig {
    
}
