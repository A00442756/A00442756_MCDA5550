package com.example.hotelreservationsystem;

public class HotelListData {

    private Integer hotelId;
    private String hotelName;
    private Integer price;
    private Boolean availability;

    public HotelListData(Integer hotelId, String hotelName, Integer price, Boolean availability) {
        super();
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.price = price;
        this.availability = availability;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPrice() {
        return "$" + Integer.toString(price);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAvailability() {
        return Boolean.toString(availability);
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
