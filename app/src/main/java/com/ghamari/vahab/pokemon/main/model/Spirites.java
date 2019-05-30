package com.ghamari.vahab.pokemon.main.model;

import com.google.gson.annotations.SerializedName;

public class Spirites {

    @SerializedName("front_default")
    private String front;

    @SerializedName("back_default")
    private String back;

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}
