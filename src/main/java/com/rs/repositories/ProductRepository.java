package com.rs.repositories;

import com.rs.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * created by rs 1/30/2022.
 */
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
