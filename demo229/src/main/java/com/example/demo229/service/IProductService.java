package com.example.demo229.service;

import com.example.demo229.entity.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);
    boolean add(Product product);
}
