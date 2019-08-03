package com.almissbah.wasit.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class TimestampConverter {
    @TypeConverter
    public Date fromTimestamp(Long value) {
        return  new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        return date.getTime();
    }
}
