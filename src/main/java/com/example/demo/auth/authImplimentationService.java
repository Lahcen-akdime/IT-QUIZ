package com.example.demo.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.RefreshRequest;
import com.example.demo.dto.request.RegistrationRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthImplimentationService implements AuthService {

    private final AuthenticationManager authenticationManager ;
    private final JwtService JwtService ;    
    private final UserRepository UserRepository ;
    private final UserMapper UserMapper ;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        final Authentication auth = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final User user = (User) auth.getPrincipal() ;
        final String token = this.JwtService.generateAccessToken(user.getUsername());
        final String refreshToken = this.JwtService.generateRefreshToken(user.getUsername());
        final String tokenType = "Bearer" ;
        return AuthenticationResponse.builder()
                                    .accessToken(token)
                                    .refreshToken(refreshToken)
                                    .tokenType(tokenType)
                                    .build() ;
    }
    @Override
    @Transactional
    public void register (final RegistrationRequest request)throws Exception {
        checkUserEmail(request.getEmail()) ;
        checkUserPasswords(request.getPassword(),request.getConfirmedPassword()) ;
        final User user = this.UserMapper.toUser(request);
        log.debug("Saving user {}",user);
        this.UserRepository.save(user) ;
        final List<User> users = new ArrayList<>() ;
        users.add(user) ;
    }
    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) {
        final String newAccessToken = this.JwtService.refreshAccessToken(request.getRefreshToken()) ;
        final String tokenType = "Bearer" ;
        return AuthenticationResponse.builder() 
        .accessToken(newAccessToken)
        .refreshToken(request.getRefreshToken())
        .tokenType(tokenType)
        .build() ;
    }

    private void checkUserEmail(final String email)throws Exception{
        final boolean emailExists = this.UserRepository.existsByEmailIgnoreCase(email) ;
        if(emailExists){
            throw new Exception("The email already exist !");
        }

    }
    private void checkUserPasswords(final String password , final String confirmedPassword)throws Exception{
        if (password == null || !password.equals(confirmedPassword)) {
            throw new Exception("There is a problem in the password") ;
        }
    }
}
