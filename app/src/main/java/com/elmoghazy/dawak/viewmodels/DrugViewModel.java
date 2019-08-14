package com.elmoghazy.dawak.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.elmoghazy.dawak.models.Drug;
import com.elmoghazy.dawak.repostories.DrugRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DrugViewModel extends ViewModel {
    DrugRepository drugRepository;

    private MutableLiveData<List<Drug>> liveDataDrugs = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private static final String TAG = "DrugViewModel";

    public LiveData<List<Drug>> getLiveDatadrugs(){
        return liveDataDrugs;
    }
    public void init(){
        drugRepository = DrugRepository.getInstance();
        drugRepository.getDrugs().subscribe(new Observer<List<Drug>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"on subscribe");
                Log.d(TAG,d.toString());
                isLoading.setValue(true);
            }

            @Override
            public void onNext(List<Drug> drugList) {
                Log.d(TAG,"On Next retrofit");
                Log.d(TAG,drugList.get(0).toString());
                liveDataDrugs.setValue(drugList);
                isLoading.setValue(false);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"On error retrofit");
//                Log.d(TAG,e.printStackTrace());
                e.printStackTrace();
                getErrorMessage().setValue(e.getMessage());
                isLoading.setValue(false);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }
}
