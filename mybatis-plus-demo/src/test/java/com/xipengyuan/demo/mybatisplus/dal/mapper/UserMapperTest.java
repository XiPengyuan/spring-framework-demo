package com.xipengyuan.demo.mybatisplus.dal.mapper;

import com.xipengyuan.demo.mybatisplus.config.DataSourceConfig;
import com.xipengyuan.demo.mybatisplus.config.MyBatisPlusConfig;
import com.xipengyuan.demo.mybatisplus.dal.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig({DataSourceConfig.class, MyBatisPlusConfig.class})
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserEntity> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
