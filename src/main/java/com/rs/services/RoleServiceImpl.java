package com.rs.services;

import com.rs.domain.Role;
import com.rs.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by rs 1/31/2022.
 */
@Service
@Profile("springdatajpa")
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Integer id) {

        return roleRepository.findById(id).get();
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {

        return roleRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
