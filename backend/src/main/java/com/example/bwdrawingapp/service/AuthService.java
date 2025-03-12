package com.example.bwdrawingapp.service;

import com.example.bwdrawingapp.dto.LoginDto;
import com.example.bwdrawingapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для аутентификации и регистрации пользователя.
 * Включает методы для логина (генерация JWT) и регистрации нового пользователя.
 */
@Service
public class AuthService {

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
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