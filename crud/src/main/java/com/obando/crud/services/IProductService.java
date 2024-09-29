package com.obando.crud.services;

import com.obando.crud.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService{
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Product save(Product product);
    Optional<Product> delete(Integer id);
}
