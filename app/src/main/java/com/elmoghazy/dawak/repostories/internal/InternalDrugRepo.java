package com.elmoghazy.dawak.repostories.internal;

import com.elmoghazy.dawak.models.Drug;
import com.elmoghazy.dawak.repostories.IDrugRepo;

import java.util.List;

import io.reactivex.Observable;

public class InternalDrugRepo implements IDrugRepo {
    @Override
    public Observable<List<Drug>> getDrugs() {
        return null;
    }
}
