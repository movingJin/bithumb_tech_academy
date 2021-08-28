package net.movingjin.api.security.domain;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log
public class SecurityToken {
    private final String token; //외부에서 주입이 아닌, 내부에서 생성하므로 Requiered Args 안씀
    private final String key;

    public SecurityToken(String key) {
        this.token = createToken();
        this.key = key;
    }

    private String createToken() {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("alg", "HS256");
            headers.put("typ", "JWT");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data", "dummy");
            long expirationTime = 1000 * 6L * 2L;

            Date ext = new Date();
            ext.setTime(ext.getTime() + expirationTime);

            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user")
                    .setExpiration(ext)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes(StandardCharsets.UTF_8))
                    .compact();
        } catch (SecurityException e) {
            log.info("SecurityException JWT");
        } catch (
                MalformedJwtException e) {
            log.info("MalformedJwtException JWT");
        } catch (
                ExpiredJwtException e) {
            log.info("ExpiredJwtException JWT");
        } catch (
                UnsupportedJwtException e) {
            log.info("UnsupportedJwtException JWT");
        } catch (IllegalAccessError e) {
            log.info("IllegalAccessError JWT");
        }
        return null;
    }
}
