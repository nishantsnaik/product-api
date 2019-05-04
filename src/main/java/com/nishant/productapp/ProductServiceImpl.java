package com.nishant.productapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
TODO Implement java 8
 */

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        Iterable<Product> productList = repository.findAll();

        List<Product> productListFinal = new ArrayList<>();
        for (Product product : productList) {

            productListFinal.add(product);
        }
        return productListFinal;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findOne(String itemCode) {
        Optional<Product> product = repository.findByItemCode(itemCode);
        if(!product.isPresent()){
            throw new NotFoundException("Product with itemCode not found: " +itemCode);
        }
        return product.get();
    }


    @Override
    @Transactional
    public Product create(Product product) {
        Optional<Product> existing = repository.findByItemCode(product.getItemCode());
        if(existing.isPresent()){
            throw new BadRequestException("Product with itemCode already exists: " +product.getItemCode());
        }
        return repository.save(product);
    }

    @Override
    @Transactional
    public Product update(String itemCode, Product product) {
        Optional<Product> existing = repository.findByItemCode(itemCode);

        if(!existing.isPresent()){
            throw new NotFoundException("Product with itemCode not found: " +itemCode);
        }
        product.setId(existing.get().getId());
        return repository.save(product);
    }

    @Override
    @Transactional
    public void delete(String itemCode) {

        Optional<Product> existing = repository.findByItemCode(itemCode);
        if(!existing.isPresent()){

            throw new NotFoundException("Product with itemCode not found: " +itemCode);
        }
        repository.deleteById(existing.get().getId());
    }
}

