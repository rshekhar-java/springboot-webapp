package com.rs.services;

import com.rs.domain.User;

/**
 * created by rs 1/31/2022.
 */
public interface UserService extends CRUDService<User>{
    User findByUsername(String username);
}
