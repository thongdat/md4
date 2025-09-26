package com.example.demo229.repository;

import com.example.demo229.entity.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    boolean add(Product product);

}
