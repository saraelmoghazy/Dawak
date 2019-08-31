package com.elmoghazy.dawak.repostories.remote;

import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
//return retrofit instance
class ServiceProvider {
    static Retrofit retrofit;

    static Retrofit getRetrofit(String url) {
        if (retrofit == null) {
//            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//            httpLoggingInterceptor = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
