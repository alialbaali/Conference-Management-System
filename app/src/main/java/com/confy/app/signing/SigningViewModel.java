package com.confy.app.signing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.confy.data.ServiceLocator;
import com.confy.domain.Result;
import com.confy.domain.models.User;
import com.confy.domain.repositories.UserRepository;

import timber.log.Timber;

public final class SigningViewModel extends ViewModel {
    UserRepository userRepository = ServiceLocator.getUserRepository();

    private final MutableLiveData<String> mutableName = new MutableLiveData<>("");
    private final MutableLiveData<String> mutableEmail = new MutableLiveData<>("");
    private final MutableLiveData<String> mutablePassword = new MutableLiveData<>("");
    private final MutableLiveData<String> error = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> shouldNavigate = new MutableLiveData<>(false);

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

    LiveData<Boolean> shouldNavigate() {
        return shouldNavigate;
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
        System.out.println("PRINTED");
        try {
            System.out.println(getName().getValue());
            System.out.println(getEmail().getValue());
            System.out.println(getPassword().getValue());
            Result<User> result = userRepository.signUp(new User(getName().getValue(), getEmail().getValue(), getPassword().getValue()));
            if (result.isSuccess) {
                shouldNavigate.setValue(true);
            } else {
                error.setValue(result.exceptionOrNull().getMessage());
            }
        } catch (Throwable exception) {
            error.setValue(exception.getMessage());
        }

    }

    void signIn() {
        Result<User> result = userRepository.signIn(new User(getEmail().getValue(), getPassword().getValue()));
        if (result.isSuccess) {
            shouldNavigate.setValue(true);
        } else {
            error.setValue(result.exceptionOrNull().getMessage());
        }
    }

}
