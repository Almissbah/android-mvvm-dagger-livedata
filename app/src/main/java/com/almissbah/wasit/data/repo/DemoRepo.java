package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.utils.MockTestUtils;

import java.util.List;

public class DemoRepo implements AppRepository {
    public DemoRepo() {
    }

    @Override
    public LiveData<List<OfferEntity>> getAllOffers() {
        MutableLiveData<List<OfferEntity>> data = new MutableLiveData<>();
        data.setValue(MockTestUtils.mockOffers());
        return data;
    }

    @Override
    public LiveData<List<CategoryEntity>> getAllCategories() {
        return null;
    }

    @Override
    public void fetchFromServer() {

    }

    @Override
    public void likeOffer(OfferEntity offerEntity) {

    }

    @Override
    public LiveData<User> getAppUser() {
        MutableLiveData<User> data = new MutableLiveData<>();
        data.setValue(new User());
        return data;
    }

    @Override
    public LiveData<OfferEntity> getOfferById(int id) {

        MutableLiveData<OfferEntity> data = new MutableLiveData<>();
        data.setValue(MockTestUtils.mockOffers().get(1));
        return data;
    }

    @Override
    public void insertOffer(OfferEntity offerEntity) {

    }

    @Override
    public void updateOffer(OfferEntity offerEntity) {

    }

    @Override
    public LiveData<List<OfferEntity>> getLikedOffers() {
        MutableLiveData<List<OfferEntity>> data = new MutableLiveData<>();
        data.setValue(MockTestUtils.mockOffers());
        return data;
    }
}
