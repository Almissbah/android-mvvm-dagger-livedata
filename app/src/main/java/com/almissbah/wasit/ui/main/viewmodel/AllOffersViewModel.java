package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.data.repo.OfferRepository;

import java.util.List;

public class AllOffersViewModel extends AndroidViewModel {
    OfferRepository repository;
    public AllOffersViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<OfferEntity>> getAllOffers() {
        LiveData<List<OfferEntity>> allOffers = repository.getAllOffers();
        return allOffers;
    }
}
