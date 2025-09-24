package com.example.demo229.repository;

import com.example.demo229.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"chánh1","alo",10));
        productList.add(new Product(2,"chánh1","ola",12));
        productList.add(new Product(3,"chánh1","lao",12));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        int newId = productList.size() + 1;
        product.setId(newId);

        productList.add(product);
    }
}
