package in.yash.linkedin.user_service.service;

import in.yash.linkedin.user_service.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class JwtService {

    private final String jwtSecretyKey="s}&cdf{^S1r/K#u";

    private SecretKey secretKey(){
        return Keys.hmacShaKeyFor(jwtSecretyKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateJwtToken(User user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .claim("email",user.getEmail())
                .signWith(secretKey())
                .compact();

    }

}
