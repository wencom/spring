package com.wencom.test;

import com.wencom.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void insert() {
        jdbcTemplate.update("insert into account values(?, ?, ?)", 4, "ran", 18);
    }

    @Test
    public void update() {
        jdbcTemplate.update("update account set age=? where id=?", 19, 4);
    }

    @Test
    public void delete() {
        jdbcTemplate.update("delete from account where id=4");
    }

    @Test
    public void selectAll() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void selectById() {
        Account account = jdbcTemplate.queryForObject("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 2);
        System.out.println(account);
    }

    @Test
    public void selectCount() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println(count);
    }
}

