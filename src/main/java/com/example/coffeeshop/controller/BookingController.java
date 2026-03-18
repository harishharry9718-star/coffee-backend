package com.example.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.coffeeshop.entity.Booking;
import com.example.coffeeshop.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/save")
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
}
