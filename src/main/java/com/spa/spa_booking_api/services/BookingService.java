package com.spa.spa_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spa.spa_booking_api.models.Booking;
import com.spa.spa_booking_api.repositories.BookingRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByDate(String date) {
        return bookingRepository.findByDate(date);
    }

    public Booking createBooking(Booking booking) {
        List<Booking> existing = bookingRepository.findByDateAndTimeAndTreatment(
                booking.getDate(), booking.getTime(), booking.getTreatment());
        if (!existing.isEmpty()) {
            throw new RuntimeException("Already booked");
        }
        return bookingRepository.save(booking);
    }
}
