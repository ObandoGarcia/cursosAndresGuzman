package com.obando.springcloud.msvc.items.services;

import com.obando.springcloud.msvc.items.models.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    List<Item> findAll();
    Optional<Item> findById();
}
