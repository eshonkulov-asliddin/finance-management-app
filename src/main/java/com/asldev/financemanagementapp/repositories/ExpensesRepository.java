package com.asldev.financemanagementapp.repositories;

import com.asldev.financemanagementapp.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    List<Expenses> findByUserId(Long userId);
}
