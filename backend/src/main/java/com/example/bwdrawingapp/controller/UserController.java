package com.example.bwdrawingapp.controller;

import com.example.bwdrawingapp.dto.LoginDto;
import com.example.bwdrawingapp.dto.UserDTO;
import com.example.bwdrawingapp.entity.User;
import com.example.bwdrawingapp.security.JwtUtil;
import com.example.bwdrawingapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Api(tags = "User Operations", description = "Операции с пользователями (регистрация, авторизация, получение информации)")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @ApiOperation(value = "Регистрация нового пользователя", response = String.class)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @ApiParam(value = "Данные пользователя для регистрации", required = true) @Valid @RequestBody UserDTO userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }

    @ApiOperation(value = "Авторизация пользователя", response = String.class)
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @ApiParam(value = "Данные для входа (логин и пароль)", required = true) @RequestBody LoginDto loginDto) {
        String jwtToken = userService.loginUser(loginDto);
        return ResponseEntity.ok("Bearer " + jwtToken);
    }

    @ApiOperation(value = "Получить информацию о текущем пользователе", response = UserDTO.class)
    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(
            @ApiParam(value = "JWT токен для аутентификации", required = true) @RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.substring(7));  // Извлекаем username из токена
        var user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
