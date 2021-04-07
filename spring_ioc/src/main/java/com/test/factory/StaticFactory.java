package com.test.factory;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
