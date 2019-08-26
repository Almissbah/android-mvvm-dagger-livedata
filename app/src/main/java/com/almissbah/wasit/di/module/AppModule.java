package com.almissbah.wasit.di.module;


import android.app.Application;
import android.content.Context;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.data.remote.api.AuthenticationApiService;
import com.almissbah.wasit.data.remote.api.OffersApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

import static com.almissbah.wasit.AppConstants.BASE_URL;

@Module
public class AppModule {


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Provides
    @Singleton
    OffersApiService provideOffersApiService(Retrofit retrofit) {
        return retrofit.create(OffersApiService.class);
    }

    @Provides
    @Singleton
    AuthenticationApiService provideAuthenticationApiService(Retrofit retrofit) {
        return retrofit.create(AuthenticationApiService.class);
    }

    @Provides
    String provideOfferEntity() {
        return "Mohammed almissbah 2";
    }

}
