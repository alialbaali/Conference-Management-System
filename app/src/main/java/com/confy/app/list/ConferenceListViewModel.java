package com.confy.app.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.Conference;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public final class ConferenceListViewModel extends ViewModel implements ChildEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private final MutableLiveData<List<Conference>> conferences = new MutableLiveData<>(new ArrayList());

    public ConferenceListViewModel() {
        database.getReference()
                .addChildEventListener(this);
    }

    public MutableLiveData<List<Conference>> getConferences() {
        return conferences;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        conferences.getValue().add(snapshot.getValue(Conference.class));
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
