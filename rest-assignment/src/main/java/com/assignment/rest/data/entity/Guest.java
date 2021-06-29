package com.assignment.rest.data.entity;

public class Guest {
    private String firstName;
    private String lastName;
    private Gender gender;

    public Guest(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Guest{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + gender.getCode() +
                '}';
    }

}
