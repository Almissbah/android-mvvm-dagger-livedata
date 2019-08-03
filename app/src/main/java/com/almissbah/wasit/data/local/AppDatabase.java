package com.almissbah.wasit.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.almissbah.wasit.data.local.converter.OfferCategoryConverter;
import com.almissbah.wasit.data.local.converter.OfferOwnerConverter;
import com.almissbah.wasit.data.local.converter.TimestampConverter;
import com.almissbah.wasit.data.local.dao.CategoryDao;
import com.almissbah.wasit.data.local.dao.OfferDao;
import com.almissbah.wasit.data.local.entity.CategoryEntity;
import com.almissbah.wasit.data.local.entity.OfferEntity;


@Database(entities = {OfferEntity.class,CategoryEntity.class}, version = 1,  exportSchema = false)
@TypeConverters({TimestampConverter.class, OfferOwnerConverter.class, OfferCategoryConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract OfferDao offerDao();

    public abstract CategoryDao CategoryDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "wasit_database.db")
                .fallbackToDestructiveMigration().build();
    }

}
