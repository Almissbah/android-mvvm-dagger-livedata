package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.data.repo.OfferRepository;

import java.util.List;

public class LikedOffersViewModel extends AndroidViewModel {

    private OfferRepository repository;
    private LiveData<List<OfferEntity>> likedOffers;
    public LikedOffersViewModel(@NonNull Application application) {
        super(application);
        repository = new OfferRepository(application);
        likedOffers= repository.getLikedOffers();
    }

    public LiveData<List<OfferEntity>> getLikedOffers() {
        return likedOffers;
    }

    // TODO: Implement the ViewModel
}
