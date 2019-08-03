package com.almissbah.wasit.di.module;

import com.almissbah.wasit.data.remote.model.Offer;
import com.almissbah.wasit.ui.main.fragment.likedOffersFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract likedOffersFragment contributelikedOffersFragment();
}
