package com.example.bwdrawingapp.service;

import com.example.bwdrawingapp.dto.DrawingDTO;
import com.example.bwdrawingapp.entity.Drawing;
import com.example.bwdrawingapp.repository.DrawingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с рисунками.
 * Содержит логику для создания, обновления, удаления рисунков.
 */
@Service
public class DrawingService {

    private final DrawingRepository drawingRepository;

    @Autowired
    public DrawingService(DrawingRepository drawingRepository) {
        this.drawingRepository = drawingRepository;
    }

    /**
     * Создание нового рисунка.
     *
     * @param drawingDto данные для создания рисунка
     * @return созданный рисунок
     */
    public Drawing createDrawing(DrawingDTO drawingDto) {
        Drawing drawing = new Drawing();
        drawing.setName(drawingDto.getName());
        drawing.setData(drawingDto.getData());
        drawing.setCreatedAt(System.currentTimeMillis());
        drawing.setUpdatedAt(System.currentTimeMillis());
        return drawingRepository.save(drawing);
    }

    /**
     * Получение рисунка по ID.
     *
     * @param drawingId ID рисунка
     * @return объект Drawing, если найден, или null
     */
    public Drawing getDrawingById(UUID drawingId) {
        return drawingRepository.findById(drawingId).orElse(null);
    }

    /**
     * Обновление данных рисунка.
     *
     * @param drawingId  ID рисунка
     * @param drawingDto данные для обновления
     * @return обновленный рисунок
     */
    public Drawing updateDrawing(UUID drawingId, DrawingDTO drawingDto) {
        Drawing drawing = getDrawingById(drawingId);
        if (drawing != null) {
            drawing.setName(drawingDto.getName());
            drawing.setData(drawingDto.getData());
            drawing.setUpdatedAt(System.currentTimeMillis());
            return drawingRepository.save(drawing);
        }
        return null;
    }

    /**
     * Удаление рисунка по ID.
     *
     * @param drawingId ID рисунка
     */
    public void deleteDrawing(UUID drawingId) {
        drawingRepository.deleteById(drawingId);
    }

    public List<Drawing> getAllDrawings() {
        return null;
    }
}