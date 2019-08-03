package com.almissbah.wasit.utils;

import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.data.remote.model.OfferCategory;
import com.almissbah.wasit.data.remote.model.OfferOwner;

import java.util.ArrayList;
import java.util.List;

public class MockTestUtils {

    public static List<OfferEntity> mockOffers() {
        List<OfferEntity> offerEntities = new ArrayList<>();
        OfferEntity offerEntity1 = new OfferEntity(1, 2, "Ticket", "offer in tickets",
                "", false
                , "", (long) 1232423, (long) 234234, (long) 234234, new OfferOwner(), new OfferCategory());
        offerEntities.add(offerEntity1);
        OfferEntity offerEntity2 = new OfferEntity(2, 5, "Ticket 2", "offer in tickets", "", false
                , "", (long) 1232423, (long) 234234, (long) 234234, new OfferOwner(), new OfferCategory());
        offerEntities.add(offerEntity2);
        return offerEntities;
    }
}
