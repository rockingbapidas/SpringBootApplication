package com.bapi.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class JwtAuthManager implements IJwtAuthManager {
    private final String TAG = JwtAuthManager.class.getSimpleName();
    private final JWTConfig jwtConfig = JWTConfig.getJwtConfig();

    @Override
    public String extractUsername(String token) {
        Logger.getLogger(TAG).info("extractUsername " + token);
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public Date extractExpiration(String token) {
        Logger.getLogger(TAG).info("extractExpiration " + token);
        return extractClaim(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Logger.getLogger(TAG).info("extractClaim " + token);
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @NotNull
    private Key getKey() {
        Logger.getLogger(TAG).info("getKey ");
        byte[] keyBytes = Decoders.BASE64.decode(jwtConfig.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateToken(String userName) {
        Logger.getLogger(TAG).info("generateToken " + userName);
        final Map<String, Object> map = new HashMap<>();
        return createToken(map, userName);
    }

    @Override
    public boolean validateToken(String token, String userName) {
        Logger.getLogger(TAG).info("validateToken " + token);
        final String username = extractClaim(token, Claims::getSubject);
        return (username.equals(userName) && !isTokenExpired(token));
    }

    private Claims extractAllClaims(String token) {
        Logger.getLogger(TAG).info("extractAllClaims " + token);
        Key key = getKey();
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        Logger.getLogger(TAG).info("isTokenExpired " + token);
        return extractExpiration(token).before(new Date());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Logger.getLogger(TAG).info("createToken " + subject);
        Key key = getKey();
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(jwtConfig.getIssuer())
                .setAudience(jwtConfig.getAudience())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }
}
