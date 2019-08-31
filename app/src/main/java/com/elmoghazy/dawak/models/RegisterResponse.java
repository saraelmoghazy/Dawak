package com.elmoghazy.dawak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {

    @SerializedName("username")
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return
                "RegisterItem{" +
                        "name = '" + username + '\'' +
                        "}";
    }
}