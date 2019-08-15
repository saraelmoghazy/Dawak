package com.elmoghazy.dawak.repostories;

import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.repostories.internal.InternalDrugRepo;
import com.elmoghazy.dawak.repostories.remote.RemoteDrugRepo;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Singelton
 */
public class DrugRepository implements IDrugRepo {

    private static DrugRepository instance;

    private RemoteDrugRepo remoteDrugRepo = new RemoteDrugRepo();
    private InternalDrugRepo internalDrugRepo;

    public static DrugRepository getInstance() {
        if (instance == null)
            instance = new DrugRepository();
        return instance;
    }

    @Override
    public Observable<DrugsResponse> getDrugs() {
        return remoteDrugRepo.getDrugs();
    }
}

