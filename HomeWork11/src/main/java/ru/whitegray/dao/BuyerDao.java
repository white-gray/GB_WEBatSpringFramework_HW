package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.whitegray.entity.Buyer;

import java.util.List;

public interface BuyerDao extends JpaRepository <Buyer, Long> {

}
