package com.nishant.productapp;
import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findOne(String itemCode);
    public Product create(Product product);
    public Product update(String itemCode, Product product);
    public void delete(String itemCode);
}

