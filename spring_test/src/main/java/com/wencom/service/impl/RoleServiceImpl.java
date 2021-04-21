package com.wencom.service.impl;

import com.wencom.dao.RoleDao;
import com.wencom.domain.Role;
import com.wencom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(RoleService.NAME)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.create(role);
    }

    public List<Role> findAllByUserId(Long id) {
        List<Role> roleList = roleDao.findAllByUserId(id);
        return roleList;
    }
}
