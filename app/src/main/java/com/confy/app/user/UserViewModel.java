package com.confy.app.user;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.User;
import com.google.firebase.auth.FirebaseAuth;

public class UserViewModel extends ViewModel {

    MutableLiveData<User> user = new MutableLiveData<>();

    MutableLiveData<String> name = new MutableLiveData<>("");
    MutableLiveData<String> email = new MutableLiveData<>("");
    MutableLiveData<String> currentPassword = new MutableLiveData<>("");
    MutableLiveData<String> newPassword = new MutableLiveData<>("");

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getCurrentPassword() {
        return currentPassword;
    }

    public MutableLiveData<String> getNewPassword() {
        return newPassword;
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    void signOut() {
        FirebaseAuth.getInstance()
                .signOut();
    }

}
