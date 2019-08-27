package com.almissbah.wasit.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.almissbah.wasit.data.local.db.converter.OfferCategoryConverter;
import com.almissbah.wasit.data.local.db.converter.OfferOwnerConverter;
import com.almissbah.wasit.data.local.db.converter.TimestampConverter;
import com.almissbah.wasit.data.local.db.dao.CategoryDao;
import com.almissbah.wasit.data.local.db.dao.OfferDao;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;


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
