package com.confy.domain.models;

import androidx.room.PrimaryKey;

public class Paper {
    @PrimaryKey
    String id;
    User Author;
    boolean isSubmitted;
    boolean isGraded;
    boolean isApproved;
    int Grade;

    public Paper(User author, boolean isSubmitted, boolean isGraded, boolean isApproved, int grade) {
        Author = author;
        this.isSubmitted = isSubmitted;
        this.isGraded = isGraded;
        this.isApproved = isApproved;
        Grade = grade;
    }

    public User getAuthor() { return Author; }

    public boolean isSubmitted() { return isSubmitted; }

    public boolean isGraded() { return isGraded; }

    public boolean isApproved() { return isApproved; }

    public int getGrade() { return Grade; }
}
