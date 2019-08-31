package com.almissbah.wasit.di.component;

import android.app.Application;
import com.almissbah.wasit.MyApplication;
import com.almissbah.wasit.di.module.ActivityBuilderModule;
import com.almissbah.wasit.di.module.ApiModule;
import com.almissbah.wasit.di.module.DbModule;
import com.almissbah.wasit.di.module.FragmentModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiModule.class, DbModule.class, AndroidSupportInjectionModule.class, ActivityBuilderModule.class, FragmentModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
    void inject(MyApplication myApplication);
}
