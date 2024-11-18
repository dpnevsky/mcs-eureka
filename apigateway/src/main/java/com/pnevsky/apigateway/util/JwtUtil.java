package com.pnevsky.apigateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;



@Component
public class JwtUtil {

    public final String SECRET = "1234";

    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(getSignKey()).build().parseSignedClaims(token);
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
