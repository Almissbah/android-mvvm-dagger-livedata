package com.almissbah.wasit.ui.detail.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepo;
import com.almissbah.wasit.data.repo.AppRepository;

public class OfferDetailViewModel extends AndroidViewModel {
    AppRepository repository;

    public OfferDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        return repository.getOfferById(id);
    }
}
