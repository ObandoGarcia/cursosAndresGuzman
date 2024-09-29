package com.obando.springcloud.msvc.items.clients;

import com.obando.springcloud.msvc.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "localhost:8001")
public interface ProductFeignClient {

    @GetMapping
    List<Product> findAll();

    @GetMapping("/{productId}")
    ResponseEntity<Product> details(@PathVariable Long productId);
}
