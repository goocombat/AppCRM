package com.crmonline.appcrm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/crmonline-api/ws/").addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
