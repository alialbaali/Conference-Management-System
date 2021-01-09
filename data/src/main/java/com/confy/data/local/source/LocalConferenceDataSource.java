package com.confy.data.local.source;

import com.confy.domain.models.Conference;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface LocalConferenceDataSource {

    Flowable<List<Conference>> getConferences();

    Flowable<Conference> getConference(String conferenceId);

    Completable insertConference(Conference conference);

    Completable updateConference(Conference conference);

    Completable deleteConference(String conferenceId);

}
