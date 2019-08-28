package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.*;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

import java.util.List;

public class OffersViewModel extends AndroidViewModel {
    AppRepository repository;
    MediatorLiveData<List<OfferEntity>> liveData = new MediatorLiveData<>();
    LiveData<List<OfferEntity>> allOffersLiveData = new MutableLiveData<>();
    LiveData<List<OfferEntity>> categoryOffersLiveData = new MutableLiveData<>();
    public OffersViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public void getAllOffers() {
        allOffersLiveData = repository.getAllOffers();
        liveData.removeSource(categoryOffersLiveData);
        liveData.addSource(allOffersLiveData, new Observer<List<OfferEntity>>() {
            @Override
            public void onChanged(@Nullable List<OfferEntity> offerEntities) {
                liveData.setValue(offerEntities);
            }
        });
    }

    public LiveData<List<OfferEntity>> getData() {
        getAllOffers();
        return liveData;
    }

    public void getOffersByCategory(String category) {
        if (category.equals("All")) {
            getAllOffers();
        } else {
            categoryOffersLiveData = repository.getOffersByCategory(category);
            liveData.removeSource(allOffersLiveData);
            liveData.addSource(categoryOffersLiveData, new Observer<List<OfferEntity>>() {
                @Override
                public void onChanged(@Nullable List<OfferEntity> offerEntities) {
                    liveData.setValue(offerEntities);
                }
            });
        }
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
