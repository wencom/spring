package com.wencom.dao.impl;

import com.wencom.dao.UserDao;
import com.wencom.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository(UserDao.NAME)
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long createUser(User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", 1);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        Long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long roleId) {
        jdbcTemplate.update("insert into sys_user_role values(?,?)", userId, roleId);
    }

    @Override
    public void delUserById(Long id) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", id);
        jdbcTemplate.update("delete from sys_user where id=?", id);
    }
}
