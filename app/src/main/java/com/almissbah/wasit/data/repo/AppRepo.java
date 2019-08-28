package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.util.Log;
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

    public OfferDao offerDao;

    public CategoryDao categoryDao;


    private LiveData<List<OfferEntity>> allOffers;
    private LiveData<List<CategoryEntity>> allCategories;

    @Inject
    public AppRepo(OfferDao offerDao, CategoryDao categoryDao) {
        this.offerDao = offerDao;
        this.categoryDao = categoryDao;
    }

    public LiveData<OfferEntity> getOfferById(int id) {
        return offerDao.getOfferById(id);
    }

    public void insertOffer(OfferEntity offerEntity){}

    public void updateOffer(OfferEntity offerEntity){}

    public LiveData<List<OfferEntity>> getLikedOffers(){
        allOffers = offerDao.getLikedOffers();
        //   Log.d(AppRepo.class.getSimpleName(),"getLikedOffers size"+ allOffers.getValue().size());
        return allOffers;
    }

    public LiveData<List<OfferEntity>> getAllOffers() {
        allOffers = offerDao.getAllOffers();
        //Log.d(AppRepo.class.getSimpleName(),"getAllOffers size"+ allOffers.getValue().size());
        return allOffers;
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        allCategories = categoryDao.getAllCategories();

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
    public LiveData<List<OfferEntity>> getOffersByCategory(String category) {
        return offerDao.getOffersByCategories("%" + category + "%");
    }
}
