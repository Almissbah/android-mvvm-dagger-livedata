package com.almissbah.wasit.data.remote.model;

import com.almissbah.wasit.data.local.entity.OfferEntity;

import java.util.List;

public class OfferApiResponce {
    List<OfferEntity> offerEntities;

    public OfferApiResponce(List<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }

    public List<OfferEntity> getOfferEntities() {
        return offerEntities;
    }

    public void setOfferEntities(List<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }
}
