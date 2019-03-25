package com.to_do.TaskManager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by danielmalone on 10/27/17.
 */

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title_colum")
    String tiltle;

    @ColumnInfo(name = "desc_colum")
    String description;

    @ColumnInfo(name = "checkbox")
    int checkRes;

    public Task(String tiltle, String description, int checkRes) {
        this.tiltle = tiltle;
        this.description = description;
        this.checkRes=checkRes;
    }


    public int getCheckRes() {
        return checkRes;
    }

    public void setCheckRes(int checkRes) {
        this.checkRes = checkRes;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
