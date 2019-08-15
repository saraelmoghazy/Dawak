package com.elmoghazy.dawak.models;

import com.google.gson.annotations.SerializedName;

public class DrugsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"DrugsItem{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}