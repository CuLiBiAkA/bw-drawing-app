package com.example.bwdrawingapp.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс для обработки запросов, когда аутентификация не удалась или токен отсутствует/неверен.
 * Возвращает ошибку 401 (Unauthorized) с информацией о том, что требуется аутентификация.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Этот метод вызывается, если пользователь не аутентифицирован или токен не действителен.
     *
     * @param request  HTTP-запрос
     * @param response HTTP-ответ
     * @param authException исключение аутентификации
     * @throws IOException при ошибках ввода-вывода
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Устанавливаем статус 401 (Unauthorized)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token is either invalid or missing.");
    }
}