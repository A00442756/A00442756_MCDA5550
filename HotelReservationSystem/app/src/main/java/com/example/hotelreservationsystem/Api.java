package com.example.hotelreservationsystem;

import retrofit.RestAdapter;

public class Api {
    public static ApiInterface getClient(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com").build();
        ApiInterface api = restAdapter.create(ApiInterface.class);
        return api;
    }
}
