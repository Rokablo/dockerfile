package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public String login() {
        // Lógica de autenticación
        return "Login successful";
    }

    @PostMapping("/register")
    public String register() {
        // Lógica de registro
        return "Registration successful";
    }
}
