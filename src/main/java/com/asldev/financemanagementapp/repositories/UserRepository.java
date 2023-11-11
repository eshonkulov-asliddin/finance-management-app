package com.asldev.financemanagementapp.repositories;

import com.asldev.financemanagementapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}