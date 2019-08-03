package com.almissbah.wasit.data.local.converter;

import android.arch.persistence.room.TypeConverter;
import com.almissbah.wasit.data.remote.model.OfferCategory;
import com.almissbah.wasit.data.remote.model.OfferOwner;
import com.google.gson.Gson;

import java.util.Date;

public class OfferCategoryConverter {
    @TypeConverter
    public String fromOfferOwner(OfferCategory offerCategory) {
        return  new Gson().toJson(offerCategory);
    }

    @TypeConverter
    public OfferCategory stringToOfferCategory(String string) {
        return new Gson().fromJson(string,OfferCategory.class);
    }
}
