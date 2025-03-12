package com.example.bwdrawingapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Модель рисунка, которая хранит данные о каждом рисунке.
 * Используется для сохранения рисунков в базе данных.
 */
@Entity
@Table(name = "drawings")
@Data
public class Drawing {

    /**
     * ID рисунка (генерируется автоматически).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название рисунка.
     */
    @NotBlank(message = "Drawing name cannot be empty")
    private String name;

    /**
     * Данные о рисунке (например, в виде строки).
     */
    @NotNull(message = "Drawing data cannot be null")
    private String data;  // Например, это может быть строка JSON, содержащая данные о рисунке.

    /**
     * Пользователь, который создал данный рисунок.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Дата создания рисунка.
     */
    private Long createdAt;

    /**
     * Дата последнего обновления рисунка.
     */
    private Long updatedAt;
}