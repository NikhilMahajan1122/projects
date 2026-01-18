package com.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

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

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody();
    }

    public List<String> extractRoles(String token){
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class);
    }

}
