package com.rs.repositories;

import com.rs.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * created by rs 1/31/2022.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
