package com.example.bwdrawingapp.controller;

import com.example.bwdrawingapp.dto.DrawingDTO;
import com.example.bwdrawingapp.entity.Drawing;
import com.example.bwdrawingapp.service.DrawingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drawings")
@Api(tags = "Drawings", description = "Операции с рисунками")
public class DrawingController {

    @Autowired
    DrawingService drawingService;

    @ApiOperation(value = "Получить список всех рисунков", response = Drawing.class)
    @GetMapping
    public List<Drawing> getAllDrawings() {
        // Логика для получения всех рисунков
        return drawingService.getAllDrawings();
    }

    @ApiOperation(value = "Создать новый рисунок")
    @PostMapping
    public ResponseEntity<String> createDrawing(@ApiParam(value = "Информация о новом рисунке", required = true) @RequestBody DrawingDTO drawingDto) {
        // Логика для создания нового рисунка
        drawingService.createDrawing(drawingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Drawing created successfully!");
    }

    @ApiOperation(value = "Удалить рисунок по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrawing(@ApiParam(value = "ID рисунка для удаления", required = true) @PathVariable Long id) {
        // Логика для удаления рисунка
        drawingService.deleteDrawing(id);
        return ResponseEntity.ok("Drawing deleted successfully!");
    }
}