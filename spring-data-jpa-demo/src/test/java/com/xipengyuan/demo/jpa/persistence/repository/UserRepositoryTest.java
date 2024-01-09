package com.xipengyuan.demo.jpa.persistence.repository;

import com.xipengyuan.demo.jpa.config.PersistenceConfig;
import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(PersistenceConfig.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindById() {
        Optional<UserEntity> optional = userRepository.findById(1L);
        assertTrue(optional.isPresent());

        final UserEntity user = optional.get();
        assertEquals(1L, user.getId());
        assertEquals(1L, user.getResidence().getId());

        assertThrows(LazyInitializationException.class, () -> {
            String province = user.getResidence().getProvince();
            System.out.println("residence.province=" + province);
        });
    }

    @Test
    void testFindUserAgeByName() {
        Integer age = userRepository.findUserAgeByName("Tom");
        assertEquals(28, age);
    }
}
