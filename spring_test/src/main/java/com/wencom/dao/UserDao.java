package com.wencom.dao;

import com.wencom.domain.User;

import java.util.List;

public interface UserDao {
    String NAME = "userDao";

    User login(String username, String password);

    List<User> findAll();

    Long createUser(User user);

    void saveUserRoleRel(Long userId, Long roleId);

    void delUserById(Long id);
}
