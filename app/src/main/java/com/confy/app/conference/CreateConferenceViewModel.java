package com.confy.app.conference;

import androidx.lifecycle.MutableLiveData;

import com.confy.app.models.Conference;
import com.google.firebase.database.FirebaseDatabase;

public final class CreateConferenceViewModel extends ConferenceViewModel {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    private final MutableLiveData<String> title = new MutableLiveData<>("");
    private final MutableLiveData<String> description = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> shouldNavigate = new MutableLiveData<>(false);
    private final MutableLiveData<String> error = new MutableLiveData<>("");

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<Boolean> getShouldNavigate() {
        return shouldNavigate;
    }

    void createConference() {
        try {
            Conference conference = new Conference(title.getValue(), description.getValue());
            database
                    .getReference()
                    .child("conferences")
                    .push()
                    .setValue(conference)
                    .addOnSuccessListener(avoid ->
                            shouldNavigate.setValue(true)
                    )
                    .addOnFailureListener(exception ->
                            error.setValue(exception.getMessage())
                    );
        } catch (Throwable exception) {
            error.setValue(exception.getMessage());
        }
    }

}
