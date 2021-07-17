package com.example.hotelreservationsystem;

public enum GenderData {
    MALE(1), FEMALE(2), NON_BINARY(3);
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
