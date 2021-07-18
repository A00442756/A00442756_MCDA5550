package com.example.hotelreservationsystem;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GuestData implements Serializable {
    @SerializedName("guestId")
    private Long guestId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("gender")
    private GenderData gender;

    public GuestData(){}
    public GuestData(Long guestId, String firstName, String lastName, GenderData gender) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

//    public Guest() {
//    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderData getGender() {
        return gender;
    }

    public void setGender(GenderData gender) {
        this.gender = gender;
    }
}
