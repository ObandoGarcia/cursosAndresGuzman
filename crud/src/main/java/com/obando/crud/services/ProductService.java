package com.obando.crud.services;

import com.obando.crud.entities.Product;
import com.obando.crud.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Integer id, Product product) {
        Optional<Product> productTemp = productRepository.findById(id);
        if(productTemp.isPresent()){
            Product prod = productTemp.orElseThrow();
            prod.setName(product.getName());
            prod.setDescription(product.getDescription());
            prod.setPrice(product.getPrice());
            return Optional.of(productRepository.save(prod));
        }
        return productTemp;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Integer id) {
        Optional<Product> productTemp = productRepository.findById(id);
        productTemp.ifPresent(prod -> {
            productRepository.delete(prod);
        });
        return productTemp;
    }
}
