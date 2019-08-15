package com.elmoghazy.dawak.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

import com.elmoghazy.dawak.models.DrugsItem;
import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.repostories.DrugRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DrugViewModel extends ViewModel {
    DrugRepository drugRepository;

    private MutableLiveData<List<DrugsItem>> liveDataDrugs = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private static final String TAG = "DrugViewModel";
    private MutableLiveData<DrugsItem> selectedItem = new MutableLiveData<>();

    public LiveData<List<DrugsItem>> getLiveDatadrugs(){
        return liveDataDrugs;
    }
    public void init(){
        drugRepository = DrugRepository.getInstance();
        drugRepository.getDrugs().subscribe(new Observer<DrugsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"on subscribe");
                Log.d(TAG,d.toString());
                isLoading.setValue(true);
            }

            @Override
            public void onNext(DrugsResponse drugList) {
                liveDataDrugs.setValue(drugList.getDrugs());
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

    public MutableLiveData<DrugsItem> getSelectedItem() {
        return selectedItem;
    }

    public void onItemClick(Integer index){
        DrugsItem drugsItem = getDrugItem(index);
        selectedItem.setValue(drugsItem);
    }

    public DrugsItem getDrugItem(Integer index)
    {
        if(liveDataDrugs.getValue() != null && index != null && liveDataDrugs.getValue().size() > index){
            return liveDataDrugs.getValue().get(index);
        }
        return null;
    }
}
