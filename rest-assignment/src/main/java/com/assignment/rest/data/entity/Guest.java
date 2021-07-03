package com.assignment.rest.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "GUEST")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guestId;
    private String firstName;
    private String lastName;
    private Gender gender;

    public Guest(Long guestId, String firstName, String lastName, Gender gender) {
		this.guestId = guestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

    public Guest() {
    }

    public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
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


}
