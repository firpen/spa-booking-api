package com.spa.spa_booking_api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spa.spa_booking_api.models.Booking;
import com.spa.spa_booking_api.services.BookingService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping()
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking.get());
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<Booking>> getBookingsByDate(@RequestParam String date) {
        List<Booking> bookedTimes = bookingService.getBookingsByDate(date);
        if (bookedTimes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(bookedTimes);
    }

    @PostMapping()
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking created = bookingService.createBooking(booking);
        return ResponseEntity.status(201).body(created);
    }
}
