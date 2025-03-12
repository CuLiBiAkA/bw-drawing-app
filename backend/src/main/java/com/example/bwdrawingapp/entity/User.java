package com.example.bwdrawingapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Модель пользователя, которая хранит информацию о зарегистрированных пользователях.
 * Используется для сохранения данных о пользователе в базе данных.
 */
@Entity
@Table(name = "users")
@Data
public class User {

    /**
     * ID пользователя (генерируется автоматически).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя (уникальное).
     */
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * Пароль пользователя (хранится в зашифрованном виде).
     */
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    /**
     * Электронная почта пользователя.
     */
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Роли пользователя (например, USER, ADMIN).
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }
}