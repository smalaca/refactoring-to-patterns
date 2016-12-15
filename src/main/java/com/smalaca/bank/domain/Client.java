package com.smalaca.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String firstName;
    private final String lastName;
    private String city;
    private String street;
    private String houseNumber;
    private List<String> phoneNumbers = new ArrayList<String>();

    Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void changeAddress(String houseNumber, String street, String city) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
    }

    void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    void changePhoneNumber(String oldPhoneNumber, String newPhoneNumber) {
        removePhoneNumber(oldPhoneNumber);
        addPhoneNumber(newPhoneNumber);
    }

    void removePhoneNumber(String phoneNumber) {
        if (phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
    }
}
