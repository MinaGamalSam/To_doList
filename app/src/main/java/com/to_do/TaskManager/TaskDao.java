package com.to_do.TaskManager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    List<Task> getAll();

    @Query("SELECT * FROM Task where checkbox=0")
    List<Task> getUnChecked();

    @Insert
    void insert(Task... tasks);

    @Query("DELETE FROM Task")
     void delete();

    @Query("UPDATE Task set checkbox=1")
    void update();

}
