package com.xipengyuan.demo.jpa.persistence.repository;

import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import com.xipengyuan.demo.jpa.persistence.repository.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserDao {
}
