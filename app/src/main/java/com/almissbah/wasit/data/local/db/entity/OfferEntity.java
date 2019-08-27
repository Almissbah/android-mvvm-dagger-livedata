package com.almissbah.wasit.data.local.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.almissbah.wasit.data.local.db.converter.OfferCategoryConverter;
import com.almissbah.wasit.data.local.db.converter.OfferOwnerConverter;
import com.almissbah.wasit.data.local.db.converter.TimestampConverter;
import com.almissbah.wasit.data.remote.model.OfferCategory;
import com.almissbah.wasit.data.remote.model.OfferOwner;

@Entity(tableName = "offers_table")
public class OfferEntity {

    @PrimaryKey(autoGenerate = true)
    private int LID;

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

    public void setLID(int LID) {
        this.LID = LID;
    }

    public int getLID() {
        return LID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLikedDate(Long likedDate) {
        this.likedDate = likedDate;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setOfferOwner(OfferOwner offerOwner) {
        this.offerOwner = offerOwner;
    }

    public void setOfferCategory(OfferCategory offerCategory) {
        this.offerCategory = offerCategory;
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
