package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.data.repo.AppRepository;

public class ProfileViewModel extends ViewModel {
    AppRepository repository;
    LiveData<User> liveData;

    public void setRepository(AppRepository repository) {
        this.repository = repository;
        liveData = repository.getAppUser();
    }

    public LiveData<User> getAppUser() {
        return liveData;
    }
}
