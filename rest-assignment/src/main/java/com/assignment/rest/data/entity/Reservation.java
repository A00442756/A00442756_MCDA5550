package com.assignment.rest.data.entity;

import com.assignment.rest.converter.StringListConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reservationId;
    @Column(name = "HOTEL_NAME")
    private String hotelName;
    @Column(name = "CHECK_IN")
    private Date checkIn;
    @Column(name = "CHECK_OUT")
    private Date checkOut;
    @Column(name = "GUEST_LIST")
    @Convert(converter = StringListConverter.class)
    private List<Guest> guestList;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

//    public List<Guest> getGuestList() {
//        return guestList;
//    }
//
//    public void setGuestList(List<Guest> guestList) {
//        this.guestList = guestList;
//    }
}
