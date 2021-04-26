package ru.whitegray.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Product;

import java.util.List;

import static ru.whitegray.dao.ProductDao.*;

@Service
public class ProductsService implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            for (Long q=1L; q<6; q++) {
                addOrUpdateProduct(q, "Prod"+q, makeCost());
            }

            System.out.println("\tWe have a Product:");
            Product prodFromDB = ProductDao.findById(3L);
            System.out.println(prodFromDB.getId() + "   "+prodFromDB.getName() + "   "+prodFromDB.getPrice() );

            System.out.println("\n\n\tWe have a Product list:");
            List<Product> productList = ProductDao.findAll();
            for (Product q:productList) {
                System.out.println(prodFromDB.getId() + "   "+prodFromDB.getName() + "   "+prodFromDB.getPrice() );
            }

            ProductDao.deleteById(5L);

        }

    /**
     * создаеёт новое значение cost
     */
    private static float makeCost() {
        double doub = Math.random() * 10000;
        double scale = Math.pow(10, 2);
        double price = Math.ceil(doub * scale) / scale;
        return (float) price;
    }




}
