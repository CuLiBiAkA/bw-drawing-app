package com.example.bwdrawingapp.repository;

import com.example.bwdrawingapp.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с рисунками в базе данных.
 * Предоставляет стандартные CRUD операции для сущности Drawing.
 */
@Repository
public interface DrawingRepository extends JpaRepository<Drawing, Long> {

    /**
     * Поиск рисунка по имени.
     *
     * @param name название рисунка
     * @return объект рисунка, если найден, или null
     */
    Drawing findByName(String name);

    void deleteById(Long drawingId);

    Optional<Drawing> findById(Long drawingId);

    Drawing save(Drawing drawing);
}