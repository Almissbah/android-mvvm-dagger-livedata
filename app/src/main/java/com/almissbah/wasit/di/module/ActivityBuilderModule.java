package com.almissbah.wasit.di.module;

import com.almissbah.wasit.ui.detail.DetailsActivity;
import com.almissbah.wasit.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract DetailsActivity contributeDetailsActivity();
}
