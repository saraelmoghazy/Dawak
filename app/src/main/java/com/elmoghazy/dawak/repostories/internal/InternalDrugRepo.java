package com.elmoghazy.dawak.repostories.internal;

import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.repostories.IDrugRepo;

import java.util.List;

import io.reactivex.Observable;

public class InternalDrugRepo implements IDrugRepo {
    @Override
    public Observable<DrugsResponse> getDrugs() {
        return null;
    }
}
