package com.obando.springcloud.msvc.items.services;

import com.obando.springcloud.msvc.items.clients.ProductFeignClient;
import com.obando.springcloud.msvc.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeign implements IItemService {

    @Autowired
    private ProductFeignClient client;

    @Override
    public List<Item> findAll() {
        return client.findAll().stream().map( product -> {
            Random random = new Random();
            return new Item(product, random.nextInt(10) + 1);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Random random = new Random();
        return Optional.ofNullable(new Item(client.details(id).getBody(),random.nextInt(10) + 1));
    }
}
