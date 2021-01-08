package com.confy.domain.models;

import androidx.room.PrimaryKey;

public class Conference {

    @PrimaryKey
    String id;
    String name;
    String description;

    public Conference(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() { return name; }

    public String getDescription() { return description; }

    // Add the other fields...
}
