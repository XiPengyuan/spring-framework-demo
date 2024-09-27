package com.xipengyuan.demo.jpa.service;

import com.xipengyuan.demo.jpa.config.ServiceConfig;
import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(ServiceConfig.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testAddUsers() {
        List<Integer> ageList = new ArrayList<>();
        ageList.add(8);
        ageList.add(7);
        List<UserEntity> entities = userService.addUsers(ageList);
        assertEquals(entities.size(), ageList.size());

        List<Integer> ageList1 = new ArrayList<>();
        ageList1.add(18);
        ageList1.add(-1); // 这里一定会导致异常，service方法是事务的，数据都会回滚
        ageList1.add(20);
        assertThrows(IllegalArgumentException.class, () -> userService.addUsers(ageList1));
    }
}
