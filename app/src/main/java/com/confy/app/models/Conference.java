package com.confy.app.models;

import androidx.annotation.Nullable;

import java.time.LocalDateTime;

public class Conference {

    public String id;
    public String title;
    public String description;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public String invitationLink;
    public boolean isStarted;
    public int minGrade;

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

    public String getInvitationLink() {
        return invitationLink;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public int getMinGrade() {
        return minGrade;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

}
