package com.dragonjic.cubes.events24.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.dragonjic.cubes.events24.data.database.dao.EventDao;
import com.dragonjic.cubes.events24.data.model.Event;

@Database(entities = Event.class ,version = 1)
public abstract  class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract EventDao eventDao();

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "database-events24").allowMainThreadQueries().build();
        }
        return instance;
    }
}
