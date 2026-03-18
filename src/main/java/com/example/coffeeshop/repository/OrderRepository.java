package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {

}

