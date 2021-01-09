package com.confy.domain.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "conferences")
public class Conference {

    @PrimaryKey
    String id;
    String name;
    String description;
    @ColumnInfo(name = "start_date")
    LocalDateTime startDate;
    @ColumnInfo(name = "end_date")
    LocalDateTime endDate;

    public Conference(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Add the other fields...
}
