package com.smalaca.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static final int MALE = 1;
    public static final int FEMALE = 0;

    private final String firstName;
    private final String lastName;
    private final int sex;
    private String city;
    private String street;
    private String houseNumber;
    private List<String> phoneNumbers = new ArrayList<>();
    private List<ContactPerson> contacts = new ArrayList<>();

    Client(String firstName, String lastName, int sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    void changeAddress(String houseNumber, String street, String city) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
    }

    List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
