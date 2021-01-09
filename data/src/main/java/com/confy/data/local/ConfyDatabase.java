package com.confy.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.confy.data.local.source.LocalConferenceDataSource;
import com.confy.data.local.source.LocalUserDataSource;
import com.confy.domain.models.Conference;

@Database(entities = {Conference.class}, version = 1, exportSchema = false)
public abstract class ConfyDatabase extends RoomDatabase {

    public LocalUserDataSource localUserDataSource;

    public LocalConferenceDataSource localConferenceDataSource;

    private static ConfyDatabase INSTANCE = null;

    public LocalUserDataSource getLocalUserDataSource() {
        return localUserDataSource;
    }

    public static ConfyDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, ConfyDatabase.class, "Confy Database")
                    .build();
        }

        return INSTANCE;
    }

}
