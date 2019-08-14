package com.elmoghazy.dawak.repostories.remote;

import com.elmoghazy.dawak.models.Drug;
import com.elmoghazy.dawak.repostories.IDrugRepo;

import java.util.List;

import io.reactivex.Observable;

public class RemoteDrugRepo implements IDrugRepo {

    @Override
    public Observable<List<Drug>> getDrugs() {
        return ServiceProvider.getRetrofit("http://api.openweathermap.org/data/").create(ApiService.class).getDrugs();//call
    }
}
