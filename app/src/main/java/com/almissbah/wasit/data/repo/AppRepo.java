package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import com.almissbah.wasit.data.local.db.dao.CategoryDao;
import com.almissbah.wasit.data.local.db.dao.OfferDao;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AppRepo implements AppRepository {
    @Inject
    public OfferDao offerDao;
    @Inject
    public CategoryDao categoryDao;

    private LiveData<List<OfferEntity>> allOffers;
    private LiveData<List<CategoryEntity>> allCategories;

    public AppRepo() {

        allOffers= offerDao.getAllOffers();
        allCategories=categoryDao.getAllCategories();
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        return offerDao.getOfferById(id);
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

    public void fetchFromServer() {
    }

    @Override
    public void likeOffer(OfferEntity offerEntity) {
        offerDao.update(offerEntity);
    }

    @Override
    public LiveData<User> getAppUser() {
        return null;
    }
}
