package com.example.demo229.repository;

import com.example.demo229.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        productList = query.getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public boolean add(Product product) {
        try{
            entityManager.persist(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}