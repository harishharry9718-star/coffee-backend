package com.example.coffeeshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
