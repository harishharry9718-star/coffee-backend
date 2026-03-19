package com.example.coffeeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeshop.entity.MenuItem;
import com.example.coffeeshop.repository.MenuRepository;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuRepository repo;

    // ADD menu item
    @PostMapping("/add")
    public MenuItem addMenu(@RequestBody MenuItem menu){
        return repo.save(menu);
    }

    // GET all menu items
    @GetMapping("/all")
    public List<MenuItem> getAll(){
        return repo.findAll();
    }

    // DELETE item
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }

    // ⭐⭐ PASTE YOUR UPDATE METHOD HERE ⭐⭐
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Long id, @RequestBody MenuItem menu) {

    	MenuItem existing = repo.findById(id).orElse(null);

        if (existing == null)
            return ResponseEntity.notFound().build();

        existing.setName(menu.getName());
        existing.setPrice(menu.getPrice());
        existing.setImageUrl(menu.getImageUrl());

        repo.save(existing);

        return ResponseEntity.ok("Updated");
    }
}
