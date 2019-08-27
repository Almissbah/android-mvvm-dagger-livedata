package com.almissbah.wasit.db;

import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.utils.MockTestUtils;
import org.junit.Assert;
import org.junit.Test;

public class CategoryDaoTest extends DbTest {

    @Test
    public void insertAndReadMovieTest() {
        CategoryEntity categoryEntity = MockTestUtils.mockCategories().get(0);
        db.CategoryDao().insert(categoryEntity);

        CategoryEntity storedCategoryEntity = db.CategoryDao().getCategoryById(categoryEntity.getId());
        Assert.assertEquals(categoryEntity.getTitle(), categoryEntity.getTitle());
        Assert.assertEquals(categoryEntity.getId(), storedCategoryEntity.getId());
    }


    @Test
    public void updateAndReadMovieTest() {

        CategoryEntity categoryEntity = MockTestUtils.mockCategories().get(0);
        db.CategoryDao().insert(categoryEntity);

        CategoryEntity storedCategoryEntity = db.CategoryDao().getCategoryById(categoryEntity.getId());
        storedCategoryEntity.setTitle("updated Title");

        db.CategoryDao().update(storedCategoryEntity);

        CategoryEntity updatedCategoryEntity = db.CategoryDao().getCategoryById(storedCategoryEntity.getId());
        Assert.assertEquals(storedCategoryEntity.getTitle(), updatedCategoryEntity.getTitle());
        Assert.assertEquals(storedCategoryEntity.getId(), updatedCategoryEntity.getId());
    }
}
