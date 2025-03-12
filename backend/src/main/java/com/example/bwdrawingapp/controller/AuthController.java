package com.example.bwdrawingapp.controller;

import com.example.bwdrawingapp.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDto) {
        return ResponseEntity.ok("User registered successfully!");
    }
}