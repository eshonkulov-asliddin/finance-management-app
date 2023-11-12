package com.asldev.financemanagementapp.services;

import com.asldev.financemanagementapp.entities.Expenses;
import com.asldev.financemanagementapp.repositories.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }

    public Optional<Expenses> getExpensesById(Long id) {
        return expensesRepository.findById(id);
    }

    public Expenses saveExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public void deleteExpenses(Long id) {
        expensesRepository.deleteById(id);
    }
}