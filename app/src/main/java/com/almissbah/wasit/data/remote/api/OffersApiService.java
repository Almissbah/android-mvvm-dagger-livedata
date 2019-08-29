package com.almissbah.wasit.data.remote.api;


import com.almissbah.wasit.data.remote.model.CategoryApiResponce;
import com.almissbah.wasit.data.remote.model.OfferApiResponce;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OffersApiService {

    @GET("/categories/all/offers")
    Observable<OfferApiResponce> fetchAllOffers();


    @GET("/categories")
    Observable<CategoryApiResponce> fetchAllCategories();

    @GET("/categories/{category}/offers")
    Observable<OfferApiResponce> fetchOffersByCategory(@Path("category") String category);

    @GET("/categories/all/offers/{id}")
    Observable<OfferApiResponce> fetchOfferById(@Path("id") int id);

    @PUT("/categories/all/offers/{id}/like")
    Observable<OfferApiResponce> likeOffer(@Path("id") int id);
}
