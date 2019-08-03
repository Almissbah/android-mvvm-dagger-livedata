package com.almissbah.wasit.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import com.almissbah.wasit.data.local.converter.TimestampConverter;

import java.util.Date;

@Entity(tableName = "category_table")
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int _id;

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

    public void set_id(int _id) {
        this._id = _id;
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
}
