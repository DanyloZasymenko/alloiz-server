package com.alloiz.alloizserver.service.utils.model;

public class User {

    private static User instance = new User();

    public static User getInstance() {
        return instance;
    }

    private User() {
    }
}
