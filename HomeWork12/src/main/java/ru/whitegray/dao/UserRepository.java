package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitegray.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
