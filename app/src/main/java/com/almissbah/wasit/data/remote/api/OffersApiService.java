package com.almissbah.wasit.data.remote.api;

import android.arch.lifecycle.LiveData;
import com.almissbah.wasit.data.remote.model.OfferApiResponce;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OffersApiService {

    @GET("/categories/all/offers")
    Call<OfferApiResponce> fetchAllOffers();

    @GET("/categories/{category}/offers")
    Call<OfferApiResponce> fetchOffersByCategory(@Path("category") String category);

    @GET("/categories/all/offers/{id}")
    Call<OfferApiResponce> fetchOfferById(@Path("id") int id);

    @PUT("/categories/all/offers/{id}/like")
    Call<OfferApiResponce> likeOffer(@Path("id") int id);
}
