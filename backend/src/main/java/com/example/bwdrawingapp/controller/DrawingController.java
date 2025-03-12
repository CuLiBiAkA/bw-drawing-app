package com.example.bwdrawingapp.controller;

import com.example.bwdrawingapp.dto.DrawingDTO;
import com.example.bwdrawingapp.entity.Drawing;
import com.example.bwdrawingapp.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/drawings")
public class DrawingController {

    @Autowired
    DrawingService drawingService;

    @GetMapping
    public List<Drawing> getAllDrawings() {
        // Логика для получения всех рисунков
        return drawingService.getAllDrawings();
    }

    @PostMapping
    public ResponseEntity<String> createDrawing(@RequestBody DrawingDTO drawingDto) {
        // Логика для создания нового рисунка
        drawingService.createDrawing(drawingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Drawing created successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrawing(@PathVariable UUID id) {
        // Логика для удаления рисунка
        drawingService.deleteDrawing(id);
        return ResponseEntity.ok("Drawing deleted successfully!");
    }
}