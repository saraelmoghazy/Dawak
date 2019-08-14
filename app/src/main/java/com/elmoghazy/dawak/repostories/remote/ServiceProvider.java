package com.elmoghazy.dawak.repostories.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    public static Retrofit retrofit;
    public static Retrofit getRetrofit(String api) {
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(api)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
