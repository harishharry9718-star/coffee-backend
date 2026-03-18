package com.example.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.coffeeshop.entity.OrderTable;
import com.example.coffeeshop.repository.OrderRepository;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/orders")


public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/place")
    public OrderTable placeOrder(@RequestBody OrderTable order) {
        return repo.save(order);
    }

    @GetMapping("/all")
    public List<OrderTable> getAllOrders() {
        return repo.findAll();
    }
    
    @GetMapping("/status/{id}")
    public ResponseEntity<String> getStatus(@PathVariable Long id) {
        OrderTable order = orderRepository.findById(id).orElse(null);

        if (order == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(order.getStatus());
    }

    
    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(
            @PathVariable Long id,
            @RequestBody String status) {

        OrderTable order = orderRepository.findById(id).orElse(null);

        if (order == null)
            return ResponseEntity.notFound().build();

        order.setStatus(status);
        orderRepository.save(order);

        return ResponseEntity.ok("Status Updated to " + status);
    }

}
