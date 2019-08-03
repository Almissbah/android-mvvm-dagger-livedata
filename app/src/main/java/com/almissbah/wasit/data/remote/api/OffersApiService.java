package com.almissbah.wasit.data.remote.api;

import android.arch.lifecycle.LiveData;
import com.almissbah.wasit.data.remote.model.OfferApiResponce;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OffersApiService {

    @GET("offers")
    OfferApiResponce fetchAllOffers(@Path("type") String type);

    @GET("offers/{id}")
    OfferApiResponce fetchOfferById(@Path("id") int id);

    @POST("offers/{id}/like")
    OfferApiResponce likeOffer(@Path("id") int id);
}
