package com.elmoghazy.dawak.repostories;

import com.elmoghazy.dawak.models.DrugsResponse;

import java.util.List;

import io.reactivex.Observable;

public interface IDrugRepo {

    Observable<DrugsResponse> getDrugs();
}
