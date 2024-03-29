package com.almissbah.wasit.db;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import com.almissbah.wasit.data.local.db.AppDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public abstract class DbTest {

    protected AppDatabase db;

    @Before
    public void initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class).build();
    }

    @After
    public void closeDb() {
        db.close();
    }
}