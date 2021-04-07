package com.test.factory;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
