package com.xipengyuan.demo.jpa.service.impl;

import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;
import com.xipengyuan.demo.jpa.persistence.repository.UserRepository;
import com.xipengyuan.demo.jpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<UserEntity> addUsers(List<Integer> ageList) {
        List<UserEntity> saved = new ArrayList<>();
        for (Integer age : ageList) {
            Assert.isTrue(age >= 0, "非法的年龄数据");

            UserEntity user = new UserEntity();
            user.setNumber("0100" + age);
            user.setName("No" + age);
            user.setAge(age);
            user.setEmail(user.getName() + "@baomidou.com");
            UserEntity s = userRepository.save(user);
            saved.add(s);
        }
        return saved;
    }
}
