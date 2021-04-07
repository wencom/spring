package com.wencom.dao.impl;

import com.wencom.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
