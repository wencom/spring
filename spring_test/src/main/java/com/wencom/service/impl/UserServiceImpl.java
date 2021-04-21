package com.wencom.service.impl;

import com.wencom.dao.RoleDao;
import com.wencom.dao.UserDao;
import com.wencom.domain.Role;
import com.wencom.domain.User;
import com.wencom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(UserService.NAME)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User login(String username, String password) {
        User user;
        try {
            user = userDao.login(username, password);
        }catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return user;
    }

    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        userList.forEach(item -> {
            List<Role> roles = roleDao.findAllByUserId(item.getId());
            item.setRoles(roles);
        });
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.createUser(user);

        for (Long roleId : roleIds) {
            userDao.saveUserRoleRel(userId, roleId);
        }
    }

    @Override
    public void delUserById(Long id) {
        userDao.delUserById(id);
    }
}
