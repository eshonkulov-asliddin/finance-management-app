package com.asldev.financemanagementapp.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    public static final Long ID = 1L;
    public static final String NAME = "Budget Name";
    public static final Double AMOUNT = 5000.0;

    @Test
    public void givenBudget_whenSettingValues_thenCorrectValuesReturned() {
        Budget budget = new Budget();
        budget.setId(ID);
        budget.setName(NAME);
        budget.setAmount(AMOUNT);

        assertEquals(ID, budget.getId());
        assertEquals(NAME, budget.getName());
        assertEquals(AMOUNT, budget.getAmount());
    }
}