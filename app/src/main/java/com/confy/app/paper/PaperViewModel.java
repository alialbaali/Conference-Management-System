package com.confy.app.paper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.Paper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.confy.app.models.Conference;

public class PaperViewModel extends ViewModel {

    private MutableLiveData<String> AuthorId;

    private final MutableLiveData<String> error = new MutableLiveData<>("");

    public MutableLiveData<String> AuthorId() {
        return AuthorId;
    }
}
