package com.almissbah.wasit.db;

import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.utils.MockTestUtils;
import org.junit.Assert;
import org.junit.Test;

public class OfferDaoTest extends DbTest {

    @Test
    public void insertAndReadMovieTest() {
        OfferEntity offerEntity = MockTestUtils.mockOffers().get(0);
        db.offerDao().insert(offerEntity);

        OfferEntity storedOfferEntity = db.offerDao().getOfferById(offerEntity.getId());
        Assert.assertEquals(offerEntity.getLikes(), storedOfferEntity.getLikes());
        Assert.assertEquals(offerEntity.getId(), storedOfferEntity.getId());
    }


    @Test
    public void updateAndReadMovieTest() {

        OfferEntity offerEntity = MockTestUtils.mockOffers().get(0);
        db.offerDao().insert(offerEntity);

        OfferEntity storedOfferEntity = db.offerDao().getOfferById(offerEntity.getId());
        Assert.assertEquals(offerEntity.getLikes(), storedOfferEntity.getLikes());
        Assert.assertEquals(offerEntity.getId(), storedOfferEntity.getId());

        storedOfferEntity.setId(5);
        storedOfferEntity.setLikes(5);
        db.offerDao().update(storedOfferEntity);

        OfferEntity updatedOfferEntity = db.offerDao().getOfferById(storedOfferEntity.getId());
        Assert.assertEquals(5, updatedOfferEntity.getId());
        Assert.assertEquals(5, updatedOfferEntity.getLikes());
    }
}
