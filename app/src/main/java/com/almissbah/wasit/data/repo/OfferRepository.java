package com.almissbah.wasit.data.repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.almissbah.wasit.data.local.AppDatabase;
import com.almissbah.wasit.data.local.dao.CategoryDao;
import com.almissbah.wasit.data.local.dao.OfferDao;
import com.almissbah.wasit.data.local.entity.CategoryEntity;
import com.almissbah.wasit.data.local.entity.OfferEntity;

import java.util.List;

public class OfferRepository {
    private OfferDao offerDao;
    private CategoryDao categoryDao;
    private LiveData<List<OfferEntity>> allOffers;
    private LiveData<List<CategoryEntity>> allCategories;

    public OfferRepository(Application application) {
        AppDatabase appDatabase= AppDatabase.getInstance(application);
        offerDao = appDatabase.offerDao();
        categoryDao= appDatabase.CategoryDao();
        allOffers= offerDao.getAllOffers();
        allCategories=categoryDao.getAllCategories();
    }
    
    public void insertOffer(OfferEntity offerEntity){}
    public void updateOffer(OfferEntity offerEntity){}

    public LiveData<List<OfferEntity>> getLikedOffers(){
        return allOffers;
    }

    public LiveData<List<OfferEntity>> getAllOffers(){
        return allOffers;
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        return allCategories;
    }

    void fetchFromServer(){}
}
