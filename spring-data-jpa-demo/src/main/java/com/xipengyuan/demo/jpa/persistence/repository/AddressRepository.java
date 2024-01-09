package com.xipengyuan.demo.jpa.persistence.repository;

import com.xipengyuan.demo.jpa.persistence.entity.AddressEntity;
import com.xipengyuan.demo.jpa.persistence.repository.dao.AddressDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>, AddressDao {
}
