package com.zkdlu.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Service
public class CustomTokenService {
    public CustomToken allocateToken(CustomOAuth2User customOAuth2User) {
        Long tokenPeriod = 1000L * 60 * 10;
        Long refreshPeriod = 1000L * 60 * 60 * 24 * 30 * 3;

        Claims claims = Jwts.claims().setSubject(customOAuth2User.getEmail());
        claims.put("role", "USER");

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Date now = new Date();
        return new CustomToken(
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + tokenPeriod))
                        .signWith(key)
                        .compact(),
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + refreshPeriod))
                        .signWith(key)
                        .compact()
        );
    }
}
