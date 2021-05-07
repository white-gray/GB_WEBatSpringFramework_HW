package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.whitegray.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
}
