package com.example.demo.auth;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.RefreshRequest;
import com.example.demo.dto.request.RegistrationRequest;
import com.example.demo.dto.response.AuthenticationResponse;

public interface authService {
    AuthenticationResponse login(AuthenticationRequest request) ;
    void register (final RegistrationRequest request)throws Exception ;
    AuthenticationResponse refreshToken(RefreshRequest request) ;
}
