package com.almissbah.wasit.data.local.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.*;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(CategoryEntity categoryEntity);

    @Insert
    void insert(List<CategoryEntity> categoryEntities);

    @Update
    void update(CategoryEntity categoryEntity);

    @Delete
    void delete(CategoryEntity categoryEntity);

    @Query("DELETE FROM category_table")
    void deleteAllCategories();


    @Query("SELECT * FROM category_table where id= :id")
    LiveData<CategoryEntity> getCategoryById(int id);

    @Query("SELECT * FROM category_table")
    LiveData<List<CategoryEntity>> getAllCategories();



}
