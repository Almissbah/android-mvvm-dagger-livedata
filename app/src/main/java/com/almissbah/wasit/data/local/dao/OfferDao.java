package com.almissbah.wasit.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import com.almissbah.wasit.data.local.entity.OfferEntity;

import java.util.List;

@Dao
public interface OfferDao {


    @Insert
    void insert(OfferEntity OfferEntity);

    @Insert
    void insert(List<OfferEntity> OfferEntity);

    @Update
    void update(OfferEntity... OfferEntity);

    @Delete
    void delete(OfferEntity OfferEntity);

    @Query("DELETE FROM offers_table")
    void deleteAllOffers();

    @Query("SELECT * FROM `offers_table` where id = :id")
    OfferEntity getOfferById(int id);


    @Query("SELECT * FROM offers_table ORDER BY createdAt DESC")
    LiveData<List<OfferEntity>> getAllOffers();

    @Query("SELECT * FROM offers_table WHERE liked = 1 ORDER BY likedDate DESC")
    LiveData<List<OfferEntity>>  getLikedOffers();


}
