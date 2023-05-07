package com.bapi.springbackend.auth.jwt;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.function.Function;

public interface IJwtAuthService {
    String extractUsername(String token);
    Date extractExpiration(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(String userName);
    boolean validateToken(String token, String userName);
}
