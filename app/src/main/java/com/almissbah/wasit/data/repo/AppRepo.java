package com.almissbah.wasit.data.repo;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import com.almissbah.wasit.data.local.db.dao.CategoryDao;
import com.almissbah.wasit.data.local.db.dao.OfferDao;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.data.remote.CallbackWrapper;
import com.almissbah.wasit.data.remote.api.OffersApiService;
import com.almissbah.wasit.data.remote.model.CategoryApiResponce;
import com.almissbah.wasit.data.remote.model.OfferApiResponce;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AppRepo implements AppRepository {

    public OfferDao offerDao;

    public CategoryDao categoryDao;

    public OffersApiService offersApiService;
    private LiveData<List<OfferEntity>> allOffers;
    private LiveData<List<CategoryEntity>> allCategories;

    @Inject
    public AppRepo(OfferDao offerDao, CategoryDao categoryDao, OffersApiService offersApiService) {
        this.offerDao = offerDao;
        this.categoryDao = categoryDao;
        this.offersApiService = offersApiService;
    }

    public LiveData<OfferEntity> getOfferById(int id) {

        return offerDao.getOfferById(id);
    }

    public void insertOffer(OfferEntity offerEntity){}

    public void updateOffer(OfferEntity offerEntity){}

    public LiveData<List<OfferEntity>> getLikedOffers(){
        allOffers = offerDao.getLikedOffers();
        return allOffers;
    }

    public LiveData<List<OfferEntity>> getAllOffers() {
        allOffers = offerDao.getAllOffers();
        refreshOffers();
        return allOffers;
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        allCategories = categoryDao.getAllCategories();
        refreshCategories();
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
        return offerDao.getOffersByCategories("%\"" + category + "\"%");
    }


    void refreshOffers() {
        offersApiService.fetchAllOffers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallbackWrapper<OfferApiResponce>() {
                    @Override
                    public void onSuccess(OfferApiResponce offerApiResponce) {
                        offerDao.insert(offerApiResponce.getOfferEntities());
                    }
                });
    }

    void refreshCategories() {
        offersApiService.fetchAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallbackWrapper<CategoryApiResponce>() {
                    @Override
                    public void onSuccess(CategoryApiResponce categoryApiResponce) {
                        categoryDao.insert(categoryApiResponce.getData());
                    }
                });
    }
}
