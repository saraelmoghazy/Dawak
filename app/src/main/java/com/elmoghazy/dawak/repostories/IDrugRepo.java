package com.elmoghazy.dawak.repostories;

import com.elmoghazy.dawak.models.Drug;

import java.util.List;

import io.reactivex.Observable;

public interface IDrugRepo {

    Observable<List<Drug>> getDrugs();
}
