package com.elmoghazy.dawak.repostories.remote;

import com.elmoghazy.dawak.models.DrugsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("getDrugs")
    Observable<DrugsResponse> getDrugs();
}
