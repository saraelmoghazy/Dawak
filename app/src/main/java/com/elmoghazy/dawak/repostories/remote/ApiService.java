package com.elmoghazy.dawak.repostories.remote;

import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.models.RegisterResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("getDrugs")
    Observable<DrugsResponse> getDrugs();

    @FormUrlEncoded
    @POST("register")
    Observable<RegisterResponse> registerClient(@Field("username") String username,
                                                @Field("phoneNumber") String phoneNumber,
                                                @Field("address") String address);
}
