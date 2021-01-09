package com.confy.app.signing;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;


public final class SigningViewModel extends ViewModel {

    @NonNull
    private final MutableLiveData<String> name = new MutableLiveData<>("");
    @NonNull
    private final MutableLiveData<String> email = new MutableLiveData<>("");
    @NonNull
    private final MutableLiveData<String> password = new MutableLiveData<>("");
    @NonNull
    private final MutableLiveData<String> error = new MutableLiveData<>("");
    @NonNull
    private final MutableLiveData<Boolean> shouldNavigate = new MutableLiveData<>(false);

    @NonNull
    public MutableLiveData<String> getName() {
        return name;
    }

    @NonNull
    public MutableLiveData<String> getEmail() {
        return email;
    }

    @NonNull
    public MutableLiveData<String> getPassword() {
        return password;
    }

    LiveData<String> getError() {
        return error;
    }

    LiveData<Boolean> shouldNavigate() {
        return shouldNavigate;
    }

    void setName(String value) {
        name.setValue(value);
    }

    void setEmail(String value) {
        email.setValue(value);
    }

    void setPassword(String value) {
        password.setValue(value);
    }

    void signUp() {
        try {
            String email = getEmail().getValue();
            String password = getPassword().getValue();
            if (email != null && password != null) {
                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        shouldNavigate.setValue(true);
                                    } else {
                                        error.setValue(task.getException().getMessage());
                                    }
                                }
                        )
                ;
            }
            shouldNavigate.setValue(true);
        } catch (Throwable exception) {
//            error.setValue(exception.getMessage());
        }
    }

    void signIn() {
        try {
            String email = getEmail().getValue();
            String password = getPassword().getValue();
            if (email != null && password != null) {
                FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(authResult ->
                                shouldNavigate.setValue(true)
                        )
                        .addOnFailureListener(exception ->
                                error.setValue(exception.getMessage())
                        )
                ;
            }
            shouldNavigate.setValue(true);
        } catch (Throwable exception) {
            error.setValue(exception.getMessage());
        }
    }

}
