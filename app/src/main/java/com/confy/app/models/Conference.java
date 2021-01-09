package com.confy.app.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

//@Entity(tableName = "conferences")
public class Conference {

//    @PrimaryKey
    String id;
    String name;
    String description;
//    @ColumnInfo(name = "start_date")
    LocalDateTime startDate;
//    @ColumnInfo(name = "end_date")
    LocalDateTime endDate;
    Paper[] papers;
    User[] users;
    String InvitationLink;
    boolean started;
    int minimumGrade;

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

    public Paper[] getPapers() {
        return papers;
    }

    public User[] getUsers() {
        return users;
    }

    public String getInvitationLink() {
        return InvitationLink;
    }

    public boolean isStarted() {
        return started;
    }

    public int getMinimumGrade() {
        return minimumGrade;
    }

    // Add the other fields...
}
