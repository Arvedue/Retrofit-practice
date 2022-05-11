package com.example.retrofitpractice.data;

import com.google.gson.annotations.SerializedName;

public class ModelDo {
    @SerializedName("key")
    private int key;

    @SerializedName("activity")
    private String activity;

    @SerializedName("price")
    private double price;

    public int getKey() {
        return key;
    }

    public String getActivity() {
        return activity;
    }

    public double getPrice() {
        return price;
    }
}
