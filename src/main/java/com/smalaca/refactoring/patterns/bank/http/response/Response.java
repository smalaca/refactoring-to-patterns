package com.smalaca.refactoring.patterns.bank.http.response;

import org.springframework.http.HttpStatus;

public class Response {
    private final HttpStatus status;

    public Response(HttpStatus status) {
        this.status = status;
    }
}
