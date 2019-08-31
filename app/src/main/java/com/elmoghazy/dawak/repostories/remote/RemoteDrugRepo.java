package com.elmoghazy.dawak.repostories.remote;

import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.repostories.IDrugRepo;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RemoteDrugRepo implements IDrugRepo {

    @Override
    public Observable<DrugsResponse> getDrugs() {
        //https://dawak.getsandbox.com/
        //http://localhost:3333/api/
        return ServiceProvider
                .getRetrofit("http://192.168.216.2/api/").create(ApiService.class).getDrugs()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
