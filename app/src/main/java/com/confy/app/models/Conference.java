package com.confy.app.models;

import androidx.annotation.Nullable;

import java.time.LocalDateTime;

//@Entity(tableName = "conferences")
public class Conference {

    //    @PrimaryKey
    public String id;
    public String title;
    public String description;
    //    @ColumnInfo(name = "start_date")
    LocalDateTime startDate;
    //    @ColumnInfo(name = "end_date")
    LocalDateTime endDate;
    Paper[] papers;
    User[] users;
    public String InvitationLink;
    public boolean started;
    public int minimumGrade;

    public String getTime() {
        int hour = startDate.getHour();
        return hour + ":00";
    }

    public Conference() {

    }

    public Conference(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
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

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
// Add the other fields...
}
