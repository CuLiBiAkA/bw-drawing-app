package com.example.bwdrawingapp.repository;

import com.example.bwdrawingapp.entity.Drawing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с рисунками в базе данных.
 * Предоставляет стандартные CRUD операции для сущности Drawing.
 */
@Repository
public interface DrawingRepository extends CrudRepository<Drawing, UUID> {

    /**
     * Поиск рисунка по имени.
     *
     * @param name название рисунка
     * @return объект рисунка, если найден, или null
     */
    Drawing findByName(String name);

    void deleteById(UUID drawingId);

    Optional<Drawing> findById(UUID drawingId);

    Drawing save(Drawing drawing);
}