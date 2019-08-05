package com.almissbah.wasit.di.module;

import com.almissbah.wasit.ui.main.fragment.LikedOffersFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract LikedOffersFragment contributelikedOffersFragment();
}
