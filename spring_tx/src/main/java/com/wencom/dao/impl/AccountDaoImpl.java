package com.wencom.dao.impl;

import com.wencom.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void out(String name, Integer money) {
        jdbcTemplate.update("update account set money=money-? where name=?", money, name);
    }

    public void in(String name, Integer money) {
        jdbcTemplate.update("update account set money=money+? where name=?", money, name);
    }
}
