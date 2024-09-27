package com.xipengyuan.demo.hibernate.dao.impl;

import com.xipengyuan.demo.hibernate.dao.RecipeLocationDao;
import com.xipengyuan.demo.hibernate.entity.RecipeLocationEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeLocationDaoImpl implements RecipeLocationDao {

    private SessionFactory sessionFactory;

    @Override
    public List<RecipeLocationEntity> findByRecipeId(long recipeId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RecipeLocationEntity.class);
        Criterion c = Restrictions.eq("id.recipePk", recipeId);
        detachedCriteria.add(c);

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        return criteria.list();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
