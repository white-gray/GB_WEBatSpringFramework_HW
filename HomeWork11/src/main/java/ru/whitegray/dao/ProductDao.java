package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Product;

import java.util.List;

public interface ProductDao extends JpaRepository <Product, Long> {

  Product findFirstByName(String name);

//  @Query("select p from Product p where p.price < :price")
//  List<Product> findCheaperProducts(float price);
//
//  @Transactional
//  void deleteByCost(float price);

//  @Modifying
//  @Transactional
//  @Query("update Product p set p.price = :price where p.price = :oldPrice")
//  void updateCoast(float cost, float oldCost);
}
