package com.asldev.financemanagementapp.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpensesTest {

    public static final Long ID = 1L;
    public static final String EXPENSE_NAME = "Expense Name";
    public static final Double AMOUNT = 2000.0;

    @Test
    void givenExpenses_whenSettingValues_thenCorrectValuesReturned() {
        Expenses expenses = new Expenses();
        expenses.setId(ID);
        expenses.setExpenseName(EXPENSE_NAME);
        expenses.setAmount(AMOUNT);

        assertEquals(ID, expenses.getId());
        assertEquals(EXPENSE_NAME, expenses.getExpenseName());
        assertEquals(AMOUNT, expenses.getAmount());
    }

    @Test
    void testHashcodeAndEqualsMethods(){
        Expenses expenses1 = new Expenses();
        expenses1.setId(ID);
        expenses1.setExpenseName(EXPENSE_NAME);
        expenses1.setAmount(AMOUNT);

        Expenses expenses2 = new Expenses();
        expenses2.setId(ID);
        expenses2.setExpenseName(EXPENSE_NAME);
        expenses2.setAmount(AMOUNT);

        assertEquals(expenses1.hashCode(), expenses2.hashCode());
        assertEquals(expenses1, expenses2);}
}