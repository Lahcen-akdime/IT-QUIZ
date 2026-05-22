package com.example.demo.auth;

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
public class authImplimentationService implements authService {

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

    }
    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) {
        
        return null ;
    }

    private void checkUserEmail(final String email)throws Exception{
        final boolean emailExists = this.UserRepository.exexistsByEmailIgnoreCase(email) ;
        if(emailExists){
            throw new Exception("The email already exist !");
        }

    }
    private String checkUserPasswords(final String password , final String confirmedPassword){
        if (password == null || confirmedPassword) {
            
        }
    }
}
