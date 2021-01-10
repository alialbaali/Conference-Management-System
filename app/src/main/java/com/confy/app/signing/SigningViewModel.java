package com.confy.app.signing;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public final class SigningViewModel extends ViewModel {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

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

    void signUp() {
        try {
            String name = getName().getValue();
            String email = getEmail().getValue();
            String password = getPassword().getValue();
            if (email != null && password != null) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {

                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        String userId = user.getUid();

                                        firebaseDatabase.getReference()
                                                .child("users")
                                                .child(userId)
                                                .setValue(new User(name, email))
                                                .addOnCompleteListener(resultTask ->
                                                        shouldNavigate.setValue(true)
                                                );

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
                firebaseAuth.signInWithEmailAndPassword(email, password)
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
