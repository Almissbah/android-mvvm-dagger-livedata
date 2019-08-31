package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

import java.util.List;

public class LikedOffersViewModel extends ViewModel {

    private AppRepository repository;
    private LiveData<List<OfferEntity>> likedOffers;

    public LikedOffersViewModel() {

    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;

    }

    public LiveData<List<OfferEntity>> getLikedOffers() {
        likedOffers = repository.getLikedOffers();
        return likedOffers;
    }

    // TODO: Implement the ViewModel
}
