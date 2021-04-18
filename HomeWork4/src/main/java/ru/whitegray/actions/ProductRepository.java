package ru.whitegray.actions;


import org.springframework.stereotype.Component;
import ru.whitegray.products.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private static int ID;
    private List<Product> products;
    {
        products = new ArrayList<>();

        products.add(new Product(++ID, "Prod1", makePrice()));
        products.add(new Product(++ID, "Prod2", makePrice()));
        products.add(new Product(++ID, "Prod3", makePrice()));
        products.add(new Product(++ID, "Prod4", makePrice()));
        products.add(new Product(++ID, "Prod5", makePrice()));
    }


    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        return products.stream().filter (product -> product.getId() == id).findAny().orElse(null);
    }


    /**
     * создаеёт новое значение price
     */
    private float makePrice() {
        double doub = Math.random() * 10000;
        double scale = Math.pow(10, 2);
        double price = Math.ceil(doub * scale) / scale;
        return (float) price;
    }
}
