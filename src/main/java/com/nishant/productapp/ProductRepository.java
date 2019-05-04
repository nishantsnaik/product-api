
package com.nishant.productapp;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    public Optional<Product> findByItemCode(String itemCode);

}


