package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

import java.util.List;

public class OffersViewModel extends AndroidViewModel {
    AppRepository repository;
    MutableLiveData<List<OfferEntity>> liveData;
    public OffersViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<OfferEntity>> getAllOffers() {
        liveData = repository.getAllOffers();
        return liveData;
    }

    public void getOffersByCategory(CategoryEntity categoryEntity) {
        liveData = (MutableLiveData<List<OfferEntity>>) repository.getOffersByCategory(categoryEntity);

    }

    public void likeOffer(OfferEntity offerEntity) {
        repository.likeOffer(offerEntity);
    }
}
