package com.example.demo229.service;

import com.example.demo229.entity.Product;
import com.example.demo229.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository studentRepository ;
    @Override
    public List<Product> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return studentRepository.add(product);
    }
}
