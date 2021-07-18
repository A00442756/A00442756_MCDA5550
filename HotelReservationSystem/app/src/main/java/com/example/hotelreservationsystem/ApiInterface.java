package com.example.hotelreservationsystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface  {
    @GET("/hotels")
    Call<List<HotelListData>> getHotelsList();
//    public void getHotelsList(Callback<List<HotelListData>> callback);

    @POST("/reservation")
    Call<ReservationData> getReservationNumber(@Body ReservationData reservation);

}
