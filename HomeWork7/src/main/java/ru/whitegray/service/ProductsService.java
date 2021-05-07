package ru.whitegray.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


@Service
public class ProductsService implements CommandLineRunner {
//    private final EntityManager entityManager;
//    ProductDaoImpl dao = new ProductDaoImpl();
//    private final ProductDao productDao;

//    public ProductsService(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public void run(String... args) throws Exception {
//        for (Long q = 1L; q < 21; q++) {
//            addOrUpdateProduct(q, "Prod" + q, makeCost());
//        }
//        System.out.println("\tWe have a Product by ID:");
//        Product prodFromDB = dao.findById(3L);
//        prodFromDB.toString();
//        System.out.println("\tWe have a Product by name");
//        prodFromDB = dao.findByName("Prod5");
//        prodFromDB.toString();
//        System.out.println("\n\n\tWe have a Product list:");
//        List<Product> productList = dao.findAll();
//        for (Product q : productList) {
//            q.toString();
//        }
//        System.out.println("\n\n\tDelete data with id 1:");
//        dao.deleteById(1L);
//        System.out.println("\n\n\tAnd now we have a Product list:");
//        productList = dao.findAll();
//        for (Product q : productList) {
//            q.toString();
//        }
    }

//    @Modifying
//    @Transactional
//    public void addOrUpdateProduct(Long id, String name, float price) {
//        Product product = new Product(id, name, price);
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.merge(product);
//        transaction.commit();
//    }

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

