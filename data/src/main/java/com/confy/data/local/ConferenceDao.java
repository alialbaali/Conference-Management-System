package com.confy.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.confy.data.local.source.LocalConferenceDataSource;
import com.confy.domain.models.Conference;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ConferenceDao extends LocalConferenceDataSource {

    @Query("SELECT * FROM conferences")
    @Override
    Flowable<List<Conference>> getConferences();

    @Query("SELECT * FROM conferences WHERE id=:conferenceId")
    @Override
    Flowable<Conference> getConference(String conferenceId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Override
    Completable insertConference(Conference conference);

    @Update
    @Override
    Completable updateConference(Conference conference);

    @Query("DELETE FROM conferences WHERE id =:conferenceId")
    @Override
    Completable deleteConference(String conferenceId);

}
