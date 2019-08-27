package com.almissbah.wasit.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.data.repo.AppRepository;

public class ProfileViewModel extends AndroidViewModel {
    AppRepository repository;
    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepository(AppRepository repository) {
        this.repository = repository;
    }

    public LiveData<User> getAppUser() {
        return repository.getAppUser();
    }
}
