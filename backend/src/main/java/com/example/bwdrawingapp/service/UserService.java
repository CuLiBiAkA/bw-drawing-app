package com.example.bwdrawingapp.service;

import com.example.bwdrawingapp.dto.LoginDto;
import com.example.bwdrawingapp.dto.UserDTO;
import com.example.bwdrawingapp.entity.User;
import com.example.bwdrawingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Сервис для работы с пользователями.
 * Включает методы для регистрации пользователей и получения их данных.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Регистрация нового пользователя.
     *
     * @param userDto данные для регистрации пользователя
     */
    public void registerUser(UserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Хешируем пароль
        user.setRoles(Set.of("USER")); // Присваиваем роль USER по умолчанию
        userRepository.save(user);
    }

    /**
     * Получение пользователя по имени.
     *
     * @param username имя пользователя
     * @return объект User, если найден
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String loginUser(LoginDto loginDto) {
        return null;
    }
}