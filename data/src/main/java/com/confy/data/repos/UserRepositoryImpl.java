package com.confy.data.repos;

import com.confy.data.local.UserDao;
import com.confy.domain.models.User;
import com.confy.domain.repositories.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    UserDao userDao;


    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void signUp(User user) {

    }

    @Override
    public void signIn(User user) {

    }
}
