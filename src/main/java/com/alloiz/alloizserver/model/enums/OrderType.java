package com.alloiz.alloizserver.model.enums;

public enum OrderType {
    WEBSITE("Web-site"),
    DESIGN("Design"),
    OTHER("Other");

    private final String name;

    OrderType(String name) {
        this.name = name;
    }
}
