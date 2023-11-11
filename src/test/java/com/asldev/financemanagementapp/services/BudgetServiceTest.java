package com.asldev.financemanagementapp.services;

import com.asldev.financemanagementapp.entities.Budget;
import com.asldev.financemanagementapp.repositories.BudgetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BudgetServiceTest {

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetService budgetService;

    @Test
    public void givenBudget_whenSaveBudget_thenBudgetShouldBeSaved() {
        Budget mockBudget = new Budget();
        mockBudget.setId(1L);

        when(budgetRepository.save(any(Budget.class))).thenReturn(mockBudget);

        Budget savedBudget = budgetService.saveBudget(mockBudget);

        assertNotNull(savedBudget);
        assertEquals(mockBudget.getId(), savedBudget.getId());
        verify(budgetRepository).save(any(Budget.class));
    }

    @Test
    public void givenBudgetId_whenGetBudgetById_thenBudgetShouldBeRetrieved() {
        Long budgetId = 1L;
        Budget mockBudget = new Budget();
        mockBudget.setId(budgetId);

        when(budgetRepository.findById(budgetId)).thenReturn(Optional.of(mockBudget));

        Optional<Budget> retrievedBudget = budgetService.getBudgetById(budgetId);

        assertTrue(retrievedBudget.isPresent());
        assertEquals(mockBudget.getId(), retrievedBudget.get().getId());
    }

    @Test
    public void whenGetAllBudgets_thenListOfAllBudgetsShouldBeReturned() {
        Budget mockBudget1 = new Budget();
        mockBudget1.setId(1L);
        Budget mockBudget2 = new Budget();
        mockBudget2.setId(2L);

        when(budgetRepository.findAll()).thenReturn(Arrays.asList(mockBudget1, mockBudget2));

        List<Budget> budgetList = budgetService.getAllBudgets();

        assertNotNull(budgetList);
        assertEquals(2, budgetList.size());
    }

    @Test
    public void givenBudgetId_whenDeleteBudget_thenBudgetShouldBeDeleted() {
        doNothing().when(budgetRepository).deleteById(anyLong());

        budgetService.deleteBudget(1L);

        verify(budgetRepository).deleteById(anyLong());
    }
}