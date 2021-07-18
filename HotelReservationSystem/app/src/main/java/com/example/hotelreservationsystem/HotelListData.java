package com.example.hotelreservationsystem;

import com.google.gson.annotations.SerializedName;

public class HotelListData {

    @SerializedName("hotelId")
    private Integer hotelId;
    @SerializedName("hotelName")
    private String hotelName;
    @SerializedName("price")
    private Integer price;
    @SerializedName("availability")
    private Boolean availability;
    @SerializedName("photoUrl")
    private String photoUrl;

    public HotelListData(Integer hotelId, String hotelName, Integer price, Boolean availability, String photoUrl) {
        super();
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.price = price;
        this.availability = availability;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
