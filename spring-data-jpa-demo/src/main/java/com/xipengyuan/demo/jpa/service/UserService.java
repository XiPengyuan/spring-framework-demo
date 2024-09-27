package com.xipengyuan.demo.jpa.service;

import com.xipengyuan.demo.jpa.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> addUsers(List<Integer> ageList);

}
