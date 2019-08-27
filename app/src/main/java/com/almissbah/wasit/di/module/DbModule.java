package com.almissbah.wasit.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.almissbah.wasit.data.local.db.AppDatabase;
import com.almissbah.wasit.data.local.db.dao.CategoryDao;
import com.almissbah.wasit.data.local.db.dao.OfferDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(Application application) {
        return  Room.databaseBuilder(application,
                AppDatabase.class, "wasit_database.db")
                .fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    CategoryDao provideCategoryDao(AppDatabase appDatabase) {
        return appDatabase.CategoryDao();
    }


    @Provides
    @Singleton
    OfferDao provideOfferDao(AppDatabase appDatabase) {
        return appDatabase.offerDao();
    }
}
