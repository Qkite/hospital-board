package com.springboot.hospitalboard.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JwtTokenUtil {

    public static Claims parseClaims(String token, String secretKey){

        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }


    public static boolean isExpired(String token, String secretKey){

        Claims claims = parseClaims(token, secretKey);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));


    }

    public static String getUserName(String token, String secretKey){

        Claims claims = parseClaims(token, secretKey);
        return claims.get("userName", String.class);
    }
}
