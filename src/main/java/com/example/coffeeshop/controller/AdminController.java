package com.example.coffeeshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeshop.entity.Admin;
import com.example.coffeeshop.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    private AdminRepository repo;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {

        Optional<Admin> existing = repo.findByEmail(admin.getEmail());

        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists");
        }

        repo.save(admin);
        return ResponseEntity.ok("Admin registered successfully");
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {

        Optional<Admin> user = repo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok("Login success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
