package com.gateway.security;

import com.gateway.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter implements WebFilter {

    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // Public endpoints
        if (path.startsWith("/api/auth/login") || path.startsWith("/api/auth/register")) {
            return chain.filter(exchange);
        }

        // Check Authorization header
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        // Validate token
        if (!jwtUtil.validateToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Extract username + roles
        String username = jwtUtil.extractUsername(token);
        List<String> roles = jwtUtil.extractRoles(token);  // ["ADMIN", "USER"]

        // Add username & roles as new headers
        ServerHttpRequest modifiedRequest = exchange.getRequest()
                .mutate()
                .header("User-Name", username)
                .header("User-Roles", String.join(",", roles))
                .build();

        ServerWebExchange modifiedExchange = exchange.mutate()
                .request(modifiedRequest)
                .build();

        return chain.filter(modifiedExchange);
    }
}
