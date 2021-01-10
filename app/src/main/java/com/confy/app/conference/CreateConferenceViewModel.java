package com.confy.app.conference;

import androidx.lifecycle.MutableLiveData;

import com.confy.app.models.Conference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("title", conference.getTitle());
            hashMap.put("description", conference.getDescription());

            database
                    .getReference()
                    .child("conferences")
                    .push()
                    .setValue(hashMap)
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
