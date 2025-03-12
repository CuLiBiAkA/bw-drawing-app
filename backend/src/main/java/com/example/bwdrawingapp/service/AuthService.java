package com.example.bwdrawingapp.service;

import com.example.bwdrawingapp.dto.LoginDto;
import com.example.bwdrawingapp.dto.UserDTO;
import com.example.bwdrawingapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Сервис для аутентификации и регистрации пользователя.
 * Включает методы для логина (генерация JWT) и регистрации нового пользователя.
 */
@Service
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Логин пользователя и получение JWT токена.
     *
     * @param loginDto данные для входа (логин и пароль)
     * @return JWT токен
     */
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        return jwtUtil.generateToken(authentication.getName());
    }

    /**
     * Регистрация нового пользователя.
     *
     * @param userDto данные для регистрации пользователя
     */
    public void register(UserDTO userDto) {
        userService.registerUser(userDto);
    }
}