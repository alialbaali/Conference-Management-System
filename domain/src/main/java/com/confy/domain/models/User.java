package com.confy.domain.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Don't define setters for domain models! like {@link User} and {@link Conference}
 * Define getters only.
 */


@Entity(tableName = "users")
public class User {

    @PrimaryKey
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