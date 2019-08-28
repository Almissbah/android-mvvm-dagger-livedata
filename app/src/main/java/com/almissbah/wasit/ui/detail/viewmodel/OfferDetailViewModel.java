package com.almissbah.wasit.ui.detail.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

public class OfferDetailViewModel extends AndroidViewModel {
    AppRepository repository;
    LiveData<OfferEntity> offerEntityLiveData = new MutableLiveData<>();
    public OfferDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        offerEntityLiveData = repository.getOfferById(id);
        return offerEntityLiveData;
    }

    public void likeOffer(OfferEntity offerEntity) {
        offerEntity.setLiked(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                repository.likeOffer(offerEntity);
            }
        }).start();
    }
}
