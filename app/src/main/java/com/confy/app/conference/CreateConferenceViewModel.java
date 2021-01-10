package com.confy.app.conference;

import androidx.lifecycle.MutableLiveData;

import com.confy.app.models.Conference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class CreateConferenceViewModel extends ConferenceViewModel {

    private final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private final MutableLiveData<String> title = new MutableLiveData<>("");
    private final MutableLiveData<String> description = new MutableLiveData<>("");
    private final MutableLiveData<String> error = new MutableLiveData<>("");

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    void createConference() {
        try {
            Conference conference = new Conference(title.getValue(), description.getValue());
            database.child("conferences")
                    .push()
                    .setValue(conference)
                    .addOnFailureListener(exception ->
                            error.setValue(exception.getMessage())
                    );
        } catch (Throwable exception) {
            error.setValue(exception.getMessage());
        }
    }

}
