package com.example.hotelreservationsystem;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservationData implements Serializable {

    private Long reservationId;
    @SerializedName("hotelName")
    private String hotelName;
    @SerializedName("checkIn")
    private String checkIn;
    @SerializedName("checkOut")
    private String checkOut;
    @SerializedName("guestList")
    private ArrayList<GuestData> guestList;
    @SerializedName("confirmationNumber")
    private int confirmationNumber;

    public ReservationData(String hotelName, String checkIn, String checkOut, ArrayList<GuestData> guestList) {
        this.hotelName = hotelName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestList = guestList;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public ArrayList<GuestData> getGuestList() {
        return guestList;
    }

    public void setGuestList(ArrayList<GuestData> guestList) {
        this.guestList = guestList;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
