package com.confy.app.models;

import androidx.room.PrimaryKey;

public class Paper {
    @PrimaryKey
    String id;
    String authorId;
    boolean isSubmitted;
    boolean isGraded;
    boolean isApproved;
    int grade;

    public Paper(String authorId, boolean isSubmitted, boolean isGraded, boolean isApproved, int grade) {
        this.authorId = authorId;
        this.isSubmitted = isSubmitted;
        this.isGraded = isGraded;
        this.isApproved = isApproved;
        this.grade = grade;
    }

    public String getAuthor() { return authorId; }

    public boolean isSubmitted() { return isSubmitted; }

    public boolean isGraded() { return isGraded; }

    public boolean isApproved() { return isApproved; }

    public int getGrade() { return grade; }
}
