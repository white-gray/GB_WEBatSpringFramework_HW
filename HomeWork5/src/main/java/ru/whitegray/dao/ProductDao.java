package ru.whitegray.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.whitegray.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class ProductDao {
    private static EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public static void addOrUpdateProduct(Long id, String name, float price) {
        Product product = new Product(id, name, price);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if (findById(id) != null){
            entityManager.merge(product);
        }
        else {
            entityManager.persist(product);
        }
        transaction.commit();
    }

    public static Product findById(Long id) {
        return (Product) entityManager.createQuery("SELECT p FROM Product p WHERE p.id=id").getSingleResult();
    }

    public static List<Product> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM product", Product.class).getResultList();
    }

    public static void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM product WHERE id = id;");
    }
}
