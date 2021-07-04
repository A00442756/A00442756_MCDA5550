package com.assignment.rest.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Long hotelId) {
        super("Could not find a hotel with ID: " + hotelId);
    }
}

