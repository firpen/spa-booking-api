package com.spa.spa_booking_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spa.spa_booking_api.models.Booking;

public interface BookingRepository extends MongoRepository<Booking, String>  {
    List<Booking> findByDate(String date);
    List<Booking> findByDateAndTimeAndTreatment(String date, String time, String treatment);
}
