package com.confy.app.conference;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.Conference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConferenceViewModel extends ViewModel {

    private MutableLiveData<Conference> conference;
    private final MutableLiveData<String> error = new MutableLiveData<>("");

    public MutableLiveData<Conference> getConference() {
        return conference;
    }

    void fetchConference(String conferenceId) {
        if (conferenceId == "0") {
            conference.setValue(new Conference("", ""));
        } else {
            FirebaseDatabase.getInstance()
                    .getReference(conferenceId)
                    .addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Conference value = dataSnapshot.getValue(Conference.class);
                            conference.setValue(value);
                        }

                        @Override
                        public void onCancelled(DatabaseError exception) {
                            error.setValue(exception.getMessage());
                        }

                    });
            ;
        }
    }

}