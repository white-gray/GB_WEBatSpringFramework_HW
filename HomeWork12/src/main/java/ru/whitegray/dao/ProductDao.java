package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Product;

import java.util.List;

public interface ProductDao extends JpaRepository <Product, Long> {

  Product findFirstByName(String name);

}
