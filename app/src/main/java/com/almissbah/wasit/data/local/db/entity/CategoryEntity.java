package com.almissbah.wasit.data.local.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.almissbah.wasit.data.local.db.converter.TimestampConverter;

import java.util.Date;

@Entity(tableName = "category_table")
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int LID;

    private int id;

    private String title;

    @TypeConverters(TimestampConverter.class)
    private Date createdAt;

    @TypeConverters(TimestampConverter.class)
    private Date updateAt;

    public CategoryEntity(int id, String title, Date createdAt, Date updateAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getLID() {
        return LID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
