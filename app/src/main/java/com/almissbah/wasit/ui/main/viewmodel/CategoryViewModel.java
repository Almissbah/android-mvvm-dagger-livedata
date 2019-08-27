package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    AppRepository repository;
    LiveData<List<CategoryEntity>> liveData;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
        liveData = repository.getAllCategories();
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {

        return liveData;
    }

}
