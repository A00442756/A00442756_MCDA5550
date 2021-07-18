package com.example.hotelreservationsystem;

import com.google.gson.annotations.SerializedName;

public enum GenderData {
    MALE(1), FEMALE(2), NON_BINARY(3);
    @SerializedName("code")
    private int code;

    GenderData(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
