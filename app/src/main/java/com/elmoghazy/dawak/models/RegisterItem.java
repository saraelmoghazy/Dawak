package com.elmoghazy.dawak.models;

import com.google.gson.annotations.SerializedName;

public class RegisterItem{

    @SerializedName("username")
    private String username;

    public void setUsername(String name){
        this.username = name;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return
                "RegisterItem{" +
                        "name = '" + username + '\'' +
                        "}";
    }
}