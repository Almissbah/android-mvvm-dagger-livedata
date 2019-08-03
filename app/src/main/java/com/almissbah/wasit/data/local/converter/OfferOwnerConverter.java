package com.almissbah.wasit.data.local.converter;

import android.arch.persistence.room.TypeConverter;
import com.almissbah.wasit.data.remote.model.OfferOwner;
import com.google.gson.Gson;

import java.util.Date;

public class OfferOwnerConverter {
    @TypeConverter
    public String fromOfferOwner(OfferOwner offerOwner) {
        return  new Gson().toJson(offerOwner);
    }

    @TypeConverter
    public OfferOwner stringToOfferOwner(String string) {
        return new Gson().fromJson(string,OfferOwner.class);
    }
}
