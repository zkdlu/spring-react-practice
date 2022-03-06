package com.zkdlu.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
public class CustomTokenService {
    private String secretKey = "무언가를 secret key로 사용해야 하는데 뭐가 좋을까";

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public CustomToken allocateToken(CustomOAuth2User customOAuth2User) {
        Long tokenPeriod = 1000L * 60 * 10;
        Long refreshPeriod = 1000L * 60 * 60 * 24 * 30 * 3;

        Claims claims = Jwts.claims().setSubject(customOAuth2User.getEmail());
        claims.put("role", "USER");

        Date now = new Date();
        return new CustomToken(
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + tokenPeriod))
                        .signWith(getSigninKey())
                        .compact(),
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + refreshPeriod))
                        .signWith(getSigninKey())
                        .compact()
        );
    }

    public boolean verifyToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration().after(new Date());
    }

    private Key getSigninKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
