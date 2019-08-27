package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

import java.util.List;

public class OffersViewModel extends AndroidViewModel {
    AppRepository repository;

    public OffersViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<OfferEntity>> getAllOffers() {
        LiveData<List<OfferEntity>> allOffers = repository.getAllOffers();
        return allOffers;
    }

    public void likeOffer(OfferEntity offerEntity) {
        repository.likeOffer(offerEntity);
    }
}
