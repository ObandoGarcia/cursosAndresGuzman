package com.obando.springcloud.msvc.products.repositories;

import com.obando.springcloud.msvc.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
