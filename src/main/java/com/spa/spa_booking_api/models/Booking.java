package com.spa.spa_booking_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "Bookings")
public class Booking {
    
    @Id
    private String id;

    @NotBlank
    private String date;

    @NotBlank
    private String time;

    @NotNull
    private int guests;

    @NotNull
    private double totalPrice;

    @NotBlank
    private String name;

    @NotBlank
    private String treatment;

    public Booking() {}

    public Booking(String id, String date, String time, int guests, double totalPrice, String name, String treatment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.guests = guests;
        this.totalPrice = totalPrice;
        this.name = name;
        this.treatment = treatment;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getGuests() {
        return guests;
    }
    public void setGuests(int guests) {
        this.guests = guests;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

}
