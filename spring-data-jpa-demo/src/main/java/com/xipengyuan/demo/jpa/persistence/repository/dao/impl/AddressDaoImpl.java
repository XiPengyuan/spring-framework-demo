package com.xipengyuan.demo.jpa.persistence.repository.dao.impl;

import com.xipengyuan.demo.jpa.persistence.entity.AddressEntity;
import com.xipengyuan.demo.jpa.persistence.repository.dao.AddressDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> findDistrictsByProvinceAndCity(String province, String city) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        var criteriaQuery = builder.createQuery(String.class);
        Root<AddressEntity> root = criteriaQuery.from(AddressEntity.class);
        criteriaQuery.select(root.get("district"));

        List<Predicate> predicates = new ArrayList<>();
        if (province != null && !province.isEmpty()) {
            predicates.add(builder.equal(root.get("province"), province));
        }
        if (city != null && !city.isEmpty()) {
            predicates.add(builder.equal(root.get("city"), city));
        }

        Predicate[] restriction = null;
        if (!predicates.isEmpty()) {
            restriction = predicates.toArray(new Predicate[0]);
        }

        if (restriction != null) {
            criteriaQuery.where(builder.and(restriction));
        }

        var typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
