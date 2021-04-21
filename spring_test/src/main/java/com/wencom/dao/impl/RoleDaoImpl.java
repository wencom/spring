package com.wencom.dao.impl;

import com.wencom.dao.RoleDao;
import com.wencom.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(RoleDao.NAME)
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void create(Role role) {
        jdbcTemplate.update("insert into sys_role values(?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findAllByUserId(Long id) {
        List<Role> roleList = jdbcTemplate.query("select r.* from sys_user_role ur left join sys_role r on ur.roleId=r.id where ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }
}
