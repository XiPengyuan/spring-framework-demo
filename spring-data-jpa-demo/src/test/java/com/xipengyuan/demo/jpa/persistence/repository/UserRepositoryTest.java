package com.xipengyuan.demo.jpa.persistence.repository;

import com.xipengyuan.demo.jpa.config.PersistenceConfig;
import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(PersistenceConfig.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindById() {
        Optional<UserEntity> optional = userRepository.findById(1L);
        assertTrue(optional.isPresent());
    }

    @Test
    void testFindUserAgeByName() {
        Integer age = userRepository.findUserAgeByName("Tom");
        assertEquals(28, age);
    }
}
