package com.almissbah.wasit.ui.detail.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.data.repo.OfferRepository;

public class OfferDetailViewModel extends AndroidViewModel {
    OfferRepository repository;

    public OfferDetailViewModel(@NonNull Application application, OfferRepository repository) {
        super(application);
        this.repository = repository;
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        return repository.getOfferById(id);
    }
}
