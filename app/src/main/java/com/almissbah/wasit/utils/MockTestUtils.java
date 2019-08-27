package com.almissbah.wasit.utils;

import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.remote.model.OfferCategory;
import com.almissbah.wasit.data.remote.model.OfferOwner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockTestUtils {
    static String mkd = "#Offer Title \n" +
            "##Secound Title \n" +
            "*Test **title** again* \n" +
            "\n * hhh " +
            "\n * h232 \n" +
            "";
    public static List<OfferEntity> mockOffers() {
        OfferOwner offerOwner = new OfferOwner();
        offerOwner.setTitle("Mohammed Corp");
        List<OfferEntity> offerEntities = new ArrayList<>();
        OfferEntity offerEntity1 = new OfferEntity(1, 2, "Ticket 1", "Have Offer in tickets 1",
                "", false
                , "", (long) 1232423, (long) 234234, (long) 234234, offerOwner, new OfferCategory());
        offerEntities.add(offerEntity1);
        OfferEntity offerEntity2 = new OfferEntity(2, 5, "Ticket 2", "Have Offer in tickets 2", mkd, false
                , "", (long) 1232423, (long) 234234, (long) 234234, offerOwner, new OfferCategory());
        offerEntities.add(offerEntity2);

        OfferEntity offerEntity3 = new OfferEntity(2, 5, "Ticket 3", "Have Offer in tickets 3", mkd, false
                , "", (long) 1232423, (long) 234234, (long) 234234, offerOwner, new OfferCategory());
        offerEntities.add(offerEntity2);

        OfferEntity offerEntity4 = new OfferEntity(2, 5, "Ticket 4", "Have Offer in tickets 4", mkd, false
                , "", (long) 1232423, (long) 234234, (long) 234234, offerOwner, new OfferCategory());
        offerEntities.add(offerEntity2);

        OfferEntity offerEntity5 = new OfferEntity(2, 5, "Ticket 5", "Have Offer in tickets 5", mkd, false
                , "", (long) 1232423, (long) 234234, (long) 234234, offerOwner, new OfferCategory());
        offerEntities.add(offerEntity2);
        return offerEntities;
    }


    public static List<CategoryEntity> mockCategories() {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        CategoryEntity categoryEntity = new CategoryEntity(1, "Electronics", new Date(12222), new Date(12333));
        CategoryEntity categoryEntity2 = new CategoryEntity(2, "Cars", new Date(1333), new Date(133));
        categoryEntities.add(categoryEntity);
        categoryEntities.add(categoryEntity2);
        return categoryEntities;
    }
}
