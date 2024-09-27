package com.xipengyuan.demo.hibernate.dao;

import com.xipengyuan.demo.hibernate.entity.RecipeLocationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(locations = "classpath:spring-hibernate-context.xml")
class RecipeLocationDaoTest {

    @Autowired
    private RecipeLocationDao recipeLocationDao;

    @Test
    void testFindByRecipeId() {
        List<RecipeLocationEntity> list = recipeLocationDao.findByRecipeId(1);
        assertNotNull(list);
    }
}
