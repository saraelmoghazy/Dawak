package com.elmoghazy.dawak.repostories;

import com.elmoghazy.dawak.models.Drug;
import com.elmoghazy.dawak.repostories.internal.InternalDrugRepo;
import com.elmoghazy.dawak.repostories.remote.RemoteDrugRepo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Singelton
 */
public class DrugRepository implements IDrugRepo {

    private static DrugRepository instance;

    private ArrayList<Drug> dataSet = new ArrayList<>();

    private RemoteDrugRepo remoteDrugRepo = new RemoteDrugRepo();
    private InternalDrugRepo internalDrugRepo;

    public static DrugRepository getInstance() {
        if (instance == null)
            instance = new DrugRepository();
        return instance;
    }

    @Override
    public Observable<List<Drug>> getDrugs() {
        return remoteDrugRepo.getDrugs();
    }
}

