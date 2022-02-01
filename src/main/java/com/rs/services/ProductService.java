package com.rs.services;

import com.rs.domain.Product;

/**
 * created by rs 1/30/2022.
 */
public interface ProductService {

    Iterable<Product> listALlProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
