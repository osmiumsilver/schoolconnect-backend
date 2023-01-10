package com.osmium.schoolconnect.backend.auth.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Author
 * @Date 2022/12/23
 * @Description
 */
@Component
public class JwtUtils {
    private static final String JWT_SIGNING_KEY="5166546A576E5A7134743777217A25432A462D4A614E645267556B58703273357538782F413F4428472B4B6250655368566D5971337436773979244226452948404D635166546A576E5A7234753778214125432A462D4A614E645267556B58703273357638792F423F4528472B4B6250655368566D597133743677397A244326";
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
public String extractUsername(String token){
    return extractClaim(token, Claims::getSubject);
}
public Date extractExpiration(String token){
    return extractClaim(token,Claims::getExpiration);
}
public boolean hasClaim(String token, String claimName) {
    final Claims claims=extractAllClaims(token);
    return claims.get(claimName)!=null;
}
private Claims extractAllClaims(String token){
    return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
}

    private Key getSignInKey() {
       byte[] keyBytes= Decoders.BASE64.decode(JWT_SIGNING_KEY);
       return Keys.hmacShaKeyFor(keyBytes);

    }

    private Boolean isTokenExpired(String token){
    return extractExpiration(token).before(new Date());
}


    private String generateToken(Map<String, Object> extraClaims,UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt((new Date(System.currentTimeMillis())))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();
    }
    private String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }
    public Boolean isTokenValid(String token,UserDetails userDetails){
    final String username=extractUsername(token);
    return(username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
}
