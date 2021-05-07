package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitegray.entity.Product;

public interface ProgectDao extends JpaRepository <Product, Long> {
}
