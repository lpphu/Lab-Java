package com.tdtu.Cinema.Security.jwt;


import com.tdtu.Cinema.Security.userprincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.MalformedInputException;
import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtsecret = "tdtu@gmail.com";
    private  int jwtExpiration = 86400;

    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS256, jwtsecret)
                .compact();
    }

    public boolean validateToken(String token){
        try {
                Jwts.parser().setSigningKey(jwtsecret).parseClaimsJwt(token);
                return  true;
        }catch (SignatureException e){
                logger.error("invalid jwt " + e);
        }catch (MalformedJwtException e){
            logger.error("invalid format " + e);
        }catch (ExpiredJwtException e){
            logger.error("invalid expired " + e);
        }catch (UnsupportedJwtException e){
            logger.error("invalid unsupport " + e);
        }catch (IllegalArgumentException e){
            logger.error("invalid claims " + e);
        }
        return false;
    }

    public String getUserNameFromtoken(String token){
        String username = Jwts.parser().setSigningKey(jwtsecret).parseClaimsJwt(token).getBody().getSubject();
        return username;
    }
}
