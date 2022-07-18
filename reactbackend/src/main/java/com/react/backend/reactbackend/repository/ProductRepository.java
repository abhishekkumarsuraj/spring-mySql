package com.react.backend.reactbackend.repository;

import com.react.backend.reactbackend.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
