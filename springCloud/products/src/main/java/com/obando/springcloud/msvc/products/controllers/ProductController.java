package com.obando.springcloud.msvc.products.controllers;

import com.obando.springcloud.msvc.products.entities.Product;
import com.obando.springcloud.msvc.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
/*@RequestMapping("/api/products")*/
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> details(@PathVariable Long productId){
        Optional<Product> productOptional = productService.findById(productId);

        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}
