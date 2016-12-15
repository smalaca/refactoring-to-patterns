package com.smalaca.bank.domain;

public class Client {
    private final String firstName;
    private final String lastName;
    private String city;
    private String street;
    private String houseNumber;
    private String phoneNumber;

    Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
