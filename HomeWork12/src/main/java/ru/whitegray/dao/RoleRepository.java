package ru.whitegray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitegray.entity.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {

}
