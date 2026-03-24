package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Servidor Spring funcionando!");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            return ResponseEntity.ok(Map.of("status", "ok", "message", "Login exitoso"));
        }
        return ResponseEntity.status(401).body(Map.of("status", "error", "message", "Credenciales incorrectas"));
    }
}