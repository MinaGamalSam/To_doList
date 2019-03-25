package com.to_do.TaskManager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by danielmalone on 10/27/17.
 */

@Database(entities = Task.class, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao userDao();
}
