package ru.whitegray.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import ru.whitegray.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductsService implements CommandLineRunner {
    private final EntityManager entityManager;

    public ProductsService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) throws Exception {
        for (Long q = 1L; q < 6; q++) {
            addOrUpdateProduct(q, "Prod" + q, makeCost());
        }
        System.out.println("\tWe have a Product by ID:");
        Product prodFromDB = findById(3L);
        prodFromDB.toString();
        System.out.println("\tWe have a Product by name");
        prodFromDB = findByName("Prod5");
        prodFromDB.toString();
        System.out.println("\n\n\tWe have a Product list:");
        List<Product> productList = findAll();
        for (Product q : productList) {
            q.toString();
        }
        System.out.println("\n\n\tDelete data with id 1:");
        deleteById(1L);
        System.out.println("\n\n\tAnd now we have a Product list:");
        productList = findAll();
        for (Product q : productList) {
            q.toString();
        }
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


    /**
     * создаеёт новое значение cost
     */
    private float makeCost() {
        double doub = Math.random() * 10000;
        double scale = Math.pow(10, 2);
        double price = Math.ceil(doub * scale) / scale;
        return (float) price;
    }
}

