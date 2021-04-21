package com.wencom.service;

import com.wencom.domain.User;

import java.util.List;

public interface UserService {
    String NAME = "userService";

    User login(String username, String password);

    List<User> findAll();

    void save(User user, Long[] roleIds);

    void delUserById(Long id);
}
