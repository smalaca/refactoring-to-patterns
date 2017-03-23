package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop;

public class Order {
    private final Products product;

    private Order(Products product) {
        this.product = product;
    }

    public static Order anOrder(Products product) {
        return new Order(product);
    }
}
