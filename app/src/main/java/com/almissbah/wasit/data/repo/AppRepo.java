package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
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

    private MutableLiveData<List<OfferEntity>> allOffers;
    private MutableLiveData<List<CategoryEntity>> allCategories;

    public AppRepo() {

        allOffers = (MutableLiveData<List<OfferEntity>>) offerDao.getAllOffers();
        allCategories = (MutableLiveData<List<CategoryEntity>>) categoryDao.getAllCategories();
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        return offerDao.getOfferById(id);
    }

    public void insertOffer(OfferEntity offerEntity){}

    public void updateOffer(OfferEntity offerEntity){}

    public LiveData<List<OfferEntity>> getLikedOffers(){
        return allOffers;
    }

    public MutableLiveData<List<OfferEntity>> getAllOffers() {
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

    @Override
    public MutableLiveData<List<OfferEntity>> getOffersByCategory(CategoryEntity categoryEntity) {
        return null;
    }
}
