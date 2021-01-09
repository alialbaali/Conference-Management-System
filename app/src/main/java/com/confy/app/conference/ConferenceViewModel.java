package com.confy.app.conference;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.confy.domain.repositories.ConferenceRepository;

public class ConferenceViewModel extends ViewModel {

    private final MutableLiveData<String> mutableTitle = new MutableLiveData<>("");
    private final MutableLiveData<String> mutableDescription = new MutableLiveData<>("");
    private final MutableLiveData<String> error = new MutableLiveData<>("");


    LiveData<String> getTitle() {
        return Transformations.distinctUntilChanged(mutableTitle);
    }

    LiveData<String> getDescription() { return Transformations.distinctUntilChanged(mutableDescription); }

    LiveData<String> getError() {
        return error;
    }

    void setTitle(String value) {
        mutableTitle.setValue(value);
    }

    void setDescription(String value) {
        mutableDescription.setValue(value);
    }

    void CreateConference() {
//        TODO()
    }
}