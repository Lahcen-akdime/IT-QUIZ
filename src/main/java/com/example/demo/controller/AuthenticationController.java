package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.AuthService;
import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.RefreshRequest;
import com.example.demo.dto.request.RegistrationRequest;
import com.example.demo.dto.response.AuthenticationResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication" , description = "Authentication API")
public class AuthenticationController {
    
    private final AuthService authService ;
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
        @Valid
        @RequestBody
        final AuthenticationRequest request){
        return ResponseEntity.ok(this.authService.login(request)) ;
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(
        @Valid
        @RequestBody
        final RegistrationRequest request)throws Exception{
        this.authService.register(request) ;
        return ResponseEntity.status(HttpStatus.CREATED).build() ;
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(
        @Valid
        @RequestBody
        final RefreshRequest request)throws Exception{
        return ResponseEntity.ok(this.authService.refreshToken(request));
    }

}
    

