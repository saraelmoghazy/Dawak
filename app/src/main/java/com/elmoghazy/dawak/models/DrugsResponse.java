package com.elmoghazy.dawak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrugsResponse{

	@SerializedName("drugs")
	private List<DrugsItem> drugs;

	public void setDrugs(List<DrugsItem> drugs){
		this.drugs = drugs;
	}

	public List<DrugsItem> getDrugs(){
		return drugs;
	}

	@Override
 	public String toString(){
		return 
			"DrugsResponse{" + 
			"drugs = '" + drugs + '\'' + 
			"}";
		}
}