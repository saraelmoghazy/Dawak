package com.elmoghazy.dawak.repostories.remote;

import com.elmoghazy.dawak.models.Drug;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("getDrugs")
    Observable<List<Drug>> getDrugs();
}
