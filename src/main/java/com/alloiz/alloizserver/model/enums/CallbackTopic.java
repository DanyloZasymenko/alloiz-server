package com.alloiz.alloizserver.model.enums;

public enum CallbackTopic {
    VACANCY("Vacancy"),
    APPEAL("Appeal"),
    ORDER("Order");

    private final String name;

    CallbackTopic(String name) {
        this.name = name;
    }
}
