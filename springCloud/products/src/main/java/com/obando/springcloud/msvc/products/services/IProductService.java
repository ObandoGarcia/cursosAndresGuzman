package com.obando.springcloud.msvc.products.services;

import com.obando.springcloud.msvc.products.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
