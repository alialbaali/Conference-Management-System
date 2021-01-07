package com.confy.domain.models;

public class User {
    String id;
    String name;
    String email;
    String password;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


}