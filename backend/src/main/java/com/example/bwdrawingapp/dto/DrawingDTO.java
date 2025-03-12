package com.example.bwdrawingapp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO для передачи информации о рисунке.
 * Содержит данные, необходимые для создания нового рисунка.
 */
@Data
public class DrawingDTO {

    /**
     * Название рисунка.
     */
    @NotBlank(message = "Drawing name cannot be empty")
    private String name;

    /**
     * Данные о содержимом рисунка (например, массив пикселей).
     */
    @NotNull(message = "Drawing data cannot be null")
    private String data;  // Например, строка JSON или Base64 кодированное изображение.

    /**
     * ID пользователя, который создал этот рисунок.
     */
    @NotNull(message = "User ID cannot be null")
    private Long userId;
}