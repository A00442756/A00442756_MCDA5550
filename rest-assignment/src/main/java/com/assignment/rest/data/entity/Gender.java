package com.assignment.rest.data.entity;

public enum Gender {
    MALE(1), FEMALE(2), NON_BINARY(3);
    private int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
