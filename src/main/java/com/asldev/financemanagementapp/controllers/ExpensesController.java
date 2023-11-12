package com.asldev.financemanagementapp.controllers;

import com.asldev.financemanagementapp.entities.Expenses;
import com.asldev.financemanagementapp.services.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        return ResponseEntity.ok(expensesService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpensesById(@PathVariable("id") Long id) {
        return expensesService.getExpensesById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Expenses> createExpenses(@Validated @RequestBody Expenses expenses) {
        return ResponseEntity.ok(expensesService.saveExpenses(expenses));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenses(@PathVariable("id") Long id) {
        expensesService.deleteExpenses(id);
        return ResponseEntity.ok().build();
    }
}