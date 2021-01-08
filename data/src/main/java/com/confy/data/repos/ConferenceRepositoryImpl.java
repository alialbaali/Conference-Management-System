package com.confy.data.repos;

import com.confy.data.local.UserDao;
import com.confy.domain.models.Conference;
import com.confy.domain.models.User;
import com.confy.domain.repositories.UserRepository;

public class ConferenceRepositoryImpl {
    UserDao userDao;

    public ConferenceRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

  //  @Override
    public void CreateConference(Conference conference) {

    }

}
