package ru.whitegray.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ProgectDao {
    private final EntityManager entityManager;

    public ProgectDao(){
        entityManager = null;
    };
    public ProgectDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addOrUpdateProduct(Long id, String name, float price) {
        Product product = new Product(id, name, price);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }

    public Product findByName(String name) {
        Product prod;
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name=:name", Product.class);
        query.setParameter("name", name);
        prod = (Product) query.getSingleResult();
        return prod;
    }

    public Product findById(Long id) {
        Product prod;
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
        query.setParameter("id", id);
        prod = (Product) query.getSingleResult();
        return prod;
    }

    public List<Product> findAll() {
        List<Product> productList = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        return productList;
    }

    @Transactional
    public void deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product prod = entityManager.find(Product.class, id);
        entityManager.remove(prod);
        transaction.commit();
    }


}
