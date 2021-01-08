package com.confy.app.signing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.confy.domain.repositories.UserRepository;

public class SigningViewModel extends ViewModel {
    UserRepository userRepository;

    private final MutableLiveData<String> mutableName = new MutableLiveData<>("");
    private final MutableLiveData<String> mutableEmail = new MutableLiveData<>("");
    private final MutableLiveData<String> mutablePassword = new MutableLiveData<>("");
    private final MutableLiveData<String> error = new MutableLiveData<>("");

    LiveData<String> getName() {
        return Transformations.distinctUntilChanged(mutableName);
    }

    public LiveData<String> getEmail() {
        return Transformations.distinctUntilChanged(mutableEmail);
    }

    public LiveData<String> getPassword() {
        return Transformations.distinctUntilChanged(mutablePassword);
    }

    LiveData<String> getError() {
        return error;
    }

    void setName(String value) {
        mutableName.setValue(value);
    }

    void setEmail(String value) {
        mutableEmail.setValue(value);
    }

    void setPassword(String value) {
        mutablePassword.setValue(value);
    }

    void signUp() {
//        TODO()
    }

}
