package com.example.demo229.repository;

import com.example.demo229.entity.Product;
import com.example.demo229.utils.ConnectionUtil;
import org.hibernate.Session; // Correct Hibernate Session import
import org.hibernate.Transaction;
import org.hibernate.query.Query; // For HQL/JPQL queries
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Product findById(int id) {
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {

            return session.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean add(Product product) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
