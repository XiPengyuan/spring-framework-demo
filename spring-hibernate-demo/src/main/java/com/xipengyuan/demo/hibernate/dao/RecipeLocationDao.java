package com.xipengyuan.demo.hibernate.dao;

import com.xipengyuan.demo.hibernate.entity.RecipeLocationEntity;

import java.util.List;

public interface RecipeLocationDao {

    List<RecipeLocationEntity> findByRecipeId(long recipeId);

}
