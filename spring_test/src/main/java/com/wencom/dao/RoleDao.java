package com.wencom.dao;

import com.wencom.domain.Role;

import java.util.List;

public interface RoleDao {
    String NAME = "roleDao";

    List<Role> findAll();

    void create(Role role);

    List<Role> findAllByUserId(Long id);
}
