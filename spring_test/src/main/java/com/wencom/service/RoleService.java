package com.wencom.service;

import com.wencom.domain.Role;

import java.util.List;

public interface RoleService {
    String NAME = "roleService";

    List<Role> findAll();

    void save(Role role);

    List<Role> findAllByUserId(Long id);
}
