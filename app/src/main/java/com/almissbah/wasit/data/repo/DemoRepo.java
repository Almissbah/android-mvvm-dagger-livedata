package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Build;
import android.util.Log;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.ui.main.adapter.OffersAdapter;
import com.almissbah.wasit.utils.MockTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoRepo implements AppRepository {
    public DemoRepo() {
    }

    @Override
    public MutableLiveData<List<OfferEntity>> getAllOffers() {
        MutableLiveData<List<OfferEntity>> data = new MutableLiveData<>();
        data.setValue(MockTestUtils.mockOffers());
        return data;
    }

    @Override
    public LiveData<List<CategoryEntity>> getAllCategories() {
        MutableLiveData<List<CategoryEntity>> data = new MutableLiveData<>();
        data.setValue(MockTestUtils.mockCategories());
        return data;
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
    public MutableLiveData<List<OfferEntity>> getOffersByCategory(CategoryEntity categoryEntity) {
        MutableLiveData<List<OfferEntity>> data = new MutableLiveData<>();
        List<OfferEntity> list = new ArrayList<>();
        list.add(MockTestUtils.mockOffers().get(1));
        list.add(MockTestUtils.mockOffers().get(2));
        data.setValue(list);
        Log.d(OffersAdapter.class.getSimpleName(), "Filtering data ");

       /* data.postValue();
            data.setValue(MockTestUtils.mockOffers().stream().filter(a-> a.getOfferCategory().getTitle().contains(categoryEntity.getTitle())).collect(Collectors.toList()));
        */
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
