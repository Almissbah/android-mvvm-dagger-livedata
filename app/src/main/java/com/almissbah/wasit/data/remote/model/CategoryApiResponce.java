package com.almissbah.wasit.data.remote.model;

import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;

import java.util.List;

public class CategoryApiResponce extends BaseResponse {
    List<CategoryEntity> data;

    public CategoryApiResponce(List<CategoryEntity> data) {
        this.data = data;
    }

    public List<CategoryEntity> getData() {
        return data;
    }

    public void setData(List<CategoryEntity> data) {
        this.data = data;
    }
}
