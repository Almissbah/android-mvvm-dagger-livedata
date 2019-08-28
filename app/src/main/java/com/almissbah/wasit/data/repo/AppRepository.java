package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;

import java.util.List;

public interface AppRepository {

    LiveData<OfferEntity> getOfferById(int id);

    void insertOffer(OfferEntity offerEntity);

    void updateOffer(OfferEntity offerEntity);

    LiveData<List<OfferEntity>> getLikedOffers();

    LiveData<List<OfferEntity>> getAllOffers();

    LiveData<List<CategoryEntity>> getAllCategories();

    void fetchFromServer();

    void likeOffer(OfferEntity offerEntity);

    LiveData<User> getAppUser();

    LiveData<List<OfferEntity>> getOffersByCategory(String category);
}
