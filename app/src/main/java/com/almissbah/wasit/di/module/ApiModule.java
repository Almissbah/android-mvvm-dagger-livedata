package com.almissbah.wasit.di.module;


import android.app.Application;
import android.content.Context;
import com.almissbah.wasit.data.local.db.dao.CategoryDao;
import com.almissbah.wasit.data.local.db.dao.OfferDao;
import com.almissbah.wasit.data.remote.api.AuthenticationApiService;
import com.almissbah.wasit.data.remote.api.OffersApiService;
import com.almissbah.wasit.data.remote.interceptor.NetworkInterceptor;
import com.almissbah.wasit.data.remote.interceptor.RequestInterceptor;
import com.almissbah.wasit.data.repo.BazarDemoRepository;
import com.almissbah.wasit.data.repo.BazarRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.almissbah.wasit.AppConstants.BASE_URL;

@Module
public class ApiModule {


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Cache provideCache(Application application) {
        long cacheSize = 10 * 1024 * 1024; // 10 MB
        File httpCacheDirectory = new File(application.getCacheDir(), "http-cache");
        return new Cache(httpCacheDirectory, cacheSize);
    }


    @Provides
    @Singleton
    NetworkInterceptor provideNetworkInterceptor(Application application) {
        return new NetworkInterceptor(application.getApplicationContext());
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache, NetworkInterceptor networkInterceptor) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(cache);
        httpClient.addInterceptor(networkInterceptor);
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new RequestInterceptor());
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).client(okHttpClient)
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
    BazarRepository provideOfferRepository(OfferDao offerDao, CategoryDao categoryDao, OffersApiService service) {
        return new BazarRepository(offerDao, categoryDao, service);
    }


    @Provides
    @Singleton
    BazarDemoRepository provideDemoRepo() {
        return new BazarDemoRepository();
    }

    @Provides
    @Singleton
    AuthenticationApiService provideAuthenticationApiService(Retrofit retrofit) {
        return retrofit.create(AuthenticationApiService.class);
    }


}
