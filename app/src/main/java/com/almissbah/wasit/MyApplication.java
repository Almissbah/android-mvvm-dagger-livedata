package com.almissbah.wasit;


import com.almissbah.wasit.di.component.AppComponent;
import com.almissbah.wasit.di.component.DaggerAppComponent;
import dagger.android.*;


public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);
        return component;
    }


}
