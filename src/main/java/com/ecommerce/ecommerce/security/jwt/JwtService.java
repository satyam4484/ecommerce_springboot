package com.ecommerce.ecommerce.security.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
// import lombok.RequiredArgsConstructor;

@Service
public class JwtService {

    @Value("${app.jwt.secretkey}")
    private String secretKey;

    @Value("${app.jwt.expiration}")
    private long accessTokenExpirationMs;

    public String generateAccessToken(User user) {
        Date now = new Date(System.currentTimeMillis());
        Date expiry = new Date(now.getTime() + accessTokenExpirationMs);

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Long getExpirationInMs() {
        return accessTokenExpirationMs;
    }

    public Long extractUserId(String token) {
        return Long.parseLong(Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = parseClaims(token);
            Date expiration = claims.getExpiration();
            if (expiration.before(new Date(System.currentTimeMillis()))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    // generate token
    // extract userId
    // istokenvalid
}
