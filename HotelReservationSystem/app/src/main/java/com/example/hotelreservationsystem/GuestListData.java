package com.example.hotelreservationsystem;

public class GuestListData {
    private Long guestId;
    private String firstName;
    private String lastName;
    private GenderData gender;

    public GuestListData(){}
    public GuestListData(Long guestId, String firstName, String lastName, GenderData gender) {
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
