package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.data.remote.model.Offer;
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
    public LiveData<List<OfferEntity>> getOffersByCategory(String category) {
        MutableLiveData<List<OfferEntity>> data = new MutableLiveData<>();

        Log.d(OffersAdapter.class.getSimpleName(), "Filtering data ");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            data.setValue(MockTestUtils.mockOffers().stream().filter(a -> a.getOfferCategory().getTitle().contains(category)).collect(Collectors.toList()));
        }
        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public LiveData<OfferEntity> getOfferById(int id) {

        MutableLiveData<OfferEntity> data = new MutableLiveData<>();
        List<OfferEntity> list = MockTestUtils.mockOffers().stream().filter(a -> a.getId() == id).collect(Collectors.toList());
        data.setValue(list.get(0));


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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            data.setValue(MockTestUtils.mockOffers().stream().filter(a -> a.isLiked()).collect(Collectors.toList()));
        }
        return data;
    }
}
