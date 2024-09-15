package com.learn2code.springdemo.mvc.model;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName="";

    @NotNull(message = "is required")
    @Min(value=0,message="The value should be an equal or greater than zero")
    @Max(value=10,message="The Value should be an equal or less than Ten")
    private Integer phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "postal code cane 5 length of character or digit")
    private String postalCode;

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
