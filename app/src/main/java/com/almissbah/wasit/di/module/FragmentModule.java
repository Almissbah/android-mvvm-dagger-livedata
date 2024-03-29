package com.almissbah.wasit.di.module;

import com.almissbah.wasit.ui.detail.fragment.OfferDetailFragment;
import com.almissbah.wasit.ui.main.fragment.OffersFragment;
import com.almissbah.wasit.ui.main.fragment.LikedOffersFragment;
import com.almissbah.wasit.ui.main.fragment.ProfileFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract LikedOffersFragment contributeLikedOffersFragment();

    @ContributesAndroidInjector
    abstract OffersFragment contributeAllOffersFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract OfferDetailFragment contributeOfferDetailFragment();
}
