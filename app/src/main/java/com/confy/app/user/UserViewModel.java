package com.confy.app.user;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.confy.app.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserViewModel extends ViewModel {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private final MutableLiveData<User> user = new MutableLiveData<>(getCurrentUser());

    private final MutableLiveData<String> name = new MutableLiveData<>("");
    private final MutableLiveData<String> email = new MutableLiveData<>("");
    private final MutableLiveData<String> currentPassword = new MutableLiveData<>("");
    private final MutableLiveData<String> newPassword = new MutableLiveData<>("");

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

    private User getCurrentUser() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        database.getReference()
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                snapshot.child("users");
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        }
                );
        return new User(
                currentUser.getUid(),
                currentUser.getDisplayName(),
                currentUser.getEmail()
        );
    }

}
