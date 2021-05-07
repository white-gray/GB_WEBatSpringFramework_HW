package ru.whitegray.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ProgectDaoImpl {
//    private final EntityManager entityManager;
//
//    public ProgectDaoImpl(){
//        entityManager = null;
//    };
//    public ProgectDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

//    @Transactional
//    public void addOrUpdateProduct(String name, float price) {
//        Product product = new Product(name, price);
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.merge(product);
//        transaction.commit();
//    }

//    public Product findByName(String name) {
//        Product prod;
//        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name=:name", Product.class);
//        query.setParameter("name", name);
//        prod = (Product) query.getSingleResult();
//        return prod;
//    }

//    public Product findById(Long id) {
//        Product prod;
//        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
//        query.setParameter("id", id);
//        prod = (Product) query.getSingleResult();
//        return prod;
//    }



//    @Transactional
//    public void deleteById(Long id) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        Product prod = entityManager.find(Product.class, id);
//        entityManager.remove(prod);
//        transaction.commit();
//    }



}
