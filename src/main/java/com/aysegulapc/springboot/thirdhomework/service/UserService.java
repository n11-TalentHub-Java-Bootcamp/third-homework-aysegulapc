package com.aysegulapc.springboot.thirdhomework.service;

import com.aysegulapc.springboot.thirdhomework.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(String id);

    User save(User user);

    void deleteById(String id);
}
