package com.asldev.financemanagementapp.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpensesTest {

    public static final Long ID = 1L;
    public static final String EXPENSE_NAME = "Expense Name";
    public static final Double AMOUNT = 2000.0;

    @Test
    public void givenExpenses_whenSettingValues_thenCorrectValuesReturned() {
        Expenses expenses = new Expenses();
        expenses.setId(ID);
        expenses.setExpenseName(EXPENSE_NAME);
        expenses.setAmount(AMOUNT);

        assertEquals(ID, expenses.getId());
        assertEquals(EXPENSE_NAME, expenses.getExpenseName());
        assertEquals(AMOUNT, expenses.getAmount());
    }
}