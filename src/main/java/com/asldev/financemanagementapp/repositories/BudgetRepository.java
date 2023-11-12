package com.asldev.financemanagementapp.repositories;

import com.asldev.financemanagementapp.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long userId);
}
