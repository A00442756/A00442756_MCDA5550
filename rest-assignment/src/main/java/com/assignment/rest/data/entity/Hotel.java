package com.assignment.rest.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOTELS")
public class Hotel {
    @Id
    @Column(name = "HOTEL_ID")
    private long hotelId;
    @Column(name = "HOTEL_NAME")
    private String hotelName;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "AVAILABILITY")
    private boolean availability;

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
