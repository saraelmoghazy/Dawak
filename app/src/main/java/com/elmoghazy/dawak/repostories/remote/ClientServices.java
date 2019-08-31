package com.elmoghazy.dawak.repostories.remote;
import com.elmoghazy.dawak.models.RegisterResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
//import okhttp3.Response;

public class ClientServices {
    public Observable<RegisterResponse> registerClient(String phoneNumber, String username, String password){
        return ServiceProvider.getRetrofit("http://localhost:3333/api/").create(ApiService.class)
                .registerClient(phoneNumber,username,password)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
