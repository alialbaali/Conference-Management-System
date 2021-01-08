package com.confy.domain.repositories;

import com.confy.domain.models.User;

public interface UserRepository {

    void signUp(User user);

    void signIn(User user);

}
