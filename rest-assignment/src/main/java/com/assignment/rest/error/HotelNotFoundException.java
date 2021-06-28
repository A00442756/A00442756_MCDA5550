package com.assignment.rest.error;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Long hotelId) {
        super("Could not find hotel with ID: " + hotelId);
    }
}
