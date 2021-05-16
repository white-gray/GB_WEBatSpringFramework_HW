package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitegray.entity.Cart;
import ru.whitegray.entity.Product;


public interface CartDao extends JpaRepository<Cart, Long> {

}
