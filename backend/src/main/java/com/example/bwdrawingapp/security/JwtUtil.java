package com.example.bwdrawingapp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "my-secret-key";  // Ваш секретный ключ

    // Генерация JWT токена
    public String generateToken(String username) {
        // Создаем секретный ключ для подписи токена
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // Токен будет действовать 1 час
                .signWith(key)  // Подписываем токен с помощью секретного ключа
                .compact();
    }

    // Получение JWT токена из заголовка запроса
    public String getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // Извлекаем токен без префикса "Bearer "
        }
        return null;
    }

    // Извлечение имени пользователя из токена
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Извлечение полезной информации (claims) из токена
    private Claims extractClaims(String token) {
        // Используем новый API для парсинга токена
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())  // Устанавливаем секретный ключ для верификации подписи
                .build()
                .parseClaimsJws(token)  // Парсим токен
                .getBody();  // Получаем тело (claims)
    }

    // Валидация токена
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Проверка истечения срока действия токена
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
