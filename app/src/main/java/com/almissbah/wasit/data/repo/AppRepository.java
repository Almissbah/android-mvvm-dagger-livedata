package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;

import java.util.List;

public interface AppRepository {

    public LiveData<OfferEntity> getOfferById(int id);

    public void insertOffer(OfferEntity offerEntity);

    public void updateOffer(OfferEntity offerEntity);

    public LiveData<List<OfferEntity>> getLikedOffers();

    public MutableLiveData<List<OfferEntity>> getAllOffers();

    public LiveData<List<CategoryEntity>> getAllCategories();

    void fetchFromServer();

    void likeOffer(OfferEntity offerEntity);

    LiveData<User> getAppUser();

    LiveData<List<OfferEntity>> getOffersByCategory(CategoryEntity categoryEntity);
}
