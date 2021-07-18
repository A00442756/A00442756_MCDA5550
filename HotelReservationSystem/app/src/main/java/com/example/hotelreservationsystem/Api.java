package com.example.hotelreservationsystem;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com";
//    private static final String BASE_URL = "http://10.0.2.2:8080";
    public static Retrofit getClient(){
        //    public static ApiInterface getClient(){
        //        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com").build();
        //        ApiInterface api = restAdapter.create(ApiInterface.class);
        //        return api;
        //    }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
