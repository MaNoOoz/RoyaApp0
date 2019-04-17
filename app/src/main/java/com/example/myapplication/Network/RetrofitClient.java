package com.example.myapplication.Network;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    //Define the base URL//
    private static Retrofit retrofit;

//Create the Retrofit instance//

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

//Add the converter//

                    .addConverterFactory(GsonConverterFactory.create())

//Build the Retrofit instance//

                    .build();
        }
        return retrofit;
    }
}
