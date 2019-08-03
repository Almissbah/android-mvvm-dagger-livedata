package com.almissbah.wasit.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.almissbah.wasit.data.local.converter.OfferCategoryConverter;
import com.almissbah.wasit.data.local.converter.OfferOwnerConverter;
import com.almissbah.wasit.data.local.converter.TimestampConverter;
import com.almissbah.wasit.data.remote.model.OfferCategory;
import com.almissbah.wasit.data.remote.model.OfferOwner;

@Entity(tableName = "offers_table")
public class OfferEntity {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    private int id;

    private int likes;

    private String title;

    private String content;

    private String description;

    private boolean liked=false;

    private String imageUrl;

    @TypeConverters(TimestampConverter.class)
    private Long likedDate;

    @TypeConverters(TimestampConverter.class)
    private Long createdAt;

    @TypeConverters(TimestampConverter.class)
    private Long updatedAt;

    @TypeConverters(OfferOwnerConverter.class)
    private OfferOwner offerOwner;

    @TypeConverters(OfferCategoryConverter.class)
    private OfferCategory offerCategory;


    public OfferEntity(int id, int likes, String title, String content, String description, boolean liked, String imageUrl, Long likedDate, Long createdAt, Long updatedAt, OfferOwner offerOwner, OfferCategory offerCategory) {
        this.id = id;
        this.likes = likes;
        this.title = title;
        this.content = content;
        this.description = description;
        this.liked = liked;
        this.imageUrl = imageUrl;
        this.likedDate = likedDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.offerOwner = offerOwner;
        this.offerCategory = offerCategory;
    }

    public void set_id(int local_id) {
        this._id = local_id;
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLiked() {
        return liked;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getLikedDate() {
        return likedDate;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public OfferOwner getOfferOwner() {
        return offerOwner;
    }

    public OfferCategory getOfferCategory() {
        return offerCategory;
    }
}
