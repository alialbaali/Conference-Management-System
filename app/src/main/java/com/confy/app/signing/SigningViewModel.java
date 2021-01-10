package com.confy.app.signing;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public final class SigningViewModel extends ViewModel {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

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

            firebaseAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {

                                String userId = firebaseAuth
                                        .getCurrentUser()
                                        .getUid();

                                createUser(new User(userId, name, email));

                                shouldNavigate.setValue(true);
                            }
                    )
                    .addOnFailureListener(exception ->
                            error.setValue(exception.getMessage())
                    );

        } catch (Throwable exception) {
            error.setValue(exception.getMessage());
        }
    }

    private void createUser(User user) {
        firebaseDatabase.getReference()
                .child("users")
                .child(user.id)
                .setValue(user);
    }

    void signIn() {
        try {
            String email = getEmail().getValue();
            String password = getPassword().getValue();

            firebaseAuth
                    .signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult ->
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
