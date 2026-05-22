package com.example.demo.security;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;

@Service
public class JwtService {
    
    private static final String TOKEN_TYPE = "token_type" ;
    private final PrivateKey privateKey ;
    private final PublicKey publicKey ;
    @Value("${spring.application.security.jwt.accessToken.expiration}")
    private Long accessTokenExpiration ;
    @Value("${spring.application.security.jwt.refreshToken.expiration}")
    private Long refreshTokenExpiration ;

    public JwtService() throws Exception{
        this.privateKey = KeyUtils.loadPrivateKey("../resources/keys/local-only/private_key.pem");
        this.publicKey = KeyUtils.loadPublicKey("../resources/keys/local-only/public_key.pem");
    }

    public String generateAccessToken(final String username){
        final Map<String , Object> claims = Map.of(TOKEN_TYPE , "ACCESS_TOKEN");
        return buildToken(username,claims,accessTokenExpiration) ;
    }

    public String generateRefreshToken(final String username){
        final Map<String , Object> claims = Map.of(TOKEN_TYPE , "REFRESH_TOKEN");
        return buildToken(username,claims,accessTokenExpiration) ;
    }
    public String buildToken(String username , final Map<String , Object> claims,final Long expiration){
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(this.privateKey)
                .compact() ;
    }
    public boolean isTokenValid(final String token , final String expectedUsername){
        final String username = extractUsername(token);
        return username.equals(expectedUsername)&&!isTokenExpired(token) ;
    }
    public String extractUsername(final String token){
        return extractclaims(token).getSubject() ;
    }
    private Claims extractclaims(final String token){
        try {
            return Jwts.parser()
            .verifyWith(this.publicKey)
            .build()
            .parseSignedClaims(token)
            .getPayload() ;
        } catch (final JwtException e) {
            throw new JwtException("Invalid Jwt token");
        }
    }
    private boolean isTokenExpired(final String token){
        return extractclaims(token).getExpiration().before(new Date()) ;
    }
    public String refreshAccessToken(final String refreshToken){
        final Claims claims = extractclaims(refreshToken) ;
        if (!"REFRESH TOKEN".equals(claims.get(TOKEN_TYPE))) {
            throw new RuntimeException("Incalid token type");
        }
        if (isTokenExpired(refreshToken)) {
            throw new RuntimeException("token expired");
        }
        final String username = claims.getSubject() ;
        return generateAccessToken(username) ;
    }

}
