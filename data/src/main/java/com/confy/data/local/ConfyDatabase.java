package com.confy.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.confy.data.local.source.LocalUserDataSource;
import com.confy.domain.models.Conference;

@Database(entities = {Conference.class}, version = 1, exportSchema = false)
public abstract class ConfyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Confy Database";

    public ConferenceDao conferenceDao;

    private static volatile ConfyDatabase INSTANCE;

    public LocalUserDataSource getLocalUserDataSource() {
        return (LocalUserDataSource) conferenceDao;
    }

    public static ConfyDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ConfyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ConfyDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
