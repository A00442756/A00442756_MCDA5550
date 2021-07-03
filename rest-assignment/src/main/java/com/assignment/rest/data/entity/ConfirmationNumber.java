package com.assignment.rest.data.entity;

public class ConfirmationNumber {
    private Long confirmationNumber;

    public ConfirmationNumber(Long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Long getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(Long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
    
    @Override
    public String toString() {
    	return "" + this.confirmationNumber + "";
    }
}
