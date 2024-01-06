package com.xipengyuan.demo.jpa.persistence.repository.dao.impl;

import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import com.xipengyuan.demo.jpa.persistence.repository.dao.UserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import org.springframework.util.Assert;

class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Integer findUserAgeByName(String name) {
        Assert.notNull(name, "User name cannot be null");

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        var criteriaQuery = builder.createQuery(Integer.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        criteriaQuery.select(root.get("age"))
                .where(builder.equal(root.get("name"), name));

        var typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }
}
