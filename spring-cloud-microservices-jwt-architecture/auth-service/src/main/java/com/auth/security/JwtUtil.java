package com.auth.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value(("${jwt.expiration}"))
    private Long jwtExpirationMs;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            log.error("Invalid Token!");
            return false;
        }

    }

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody().getSubject();
    }

}
