package com.tendersai.demo.entity;

public class HelloResponse {
    private String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}