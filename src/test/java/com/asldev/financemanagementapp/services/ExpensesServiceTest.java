package com.asldev.financemanagementapp.services;

import com.asldev.financemanagementapp.entities.Expenses;
import com.asldev.financemanagementapp.repositories.ExpensesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExpensesServiceTest {

    @Mock
    private ExpensesRepository expensesRepository;

    @InjectMocks
    private ExpensesService expensesService;

    @Test
    public void givenExpenses_whenSaveExpenses_thenExpensesShouldBeStored() {
        Expenses mockExpenses = new Expenses();
        mockExpenses.setId(1L);

        when(expensesRepository.save(any(Expenses.class))).thenReturn(mockExpenses);

        Expenses savedExpenses = expensesService.saveExpenses(mockExpenses);

        assertNotNull(savedExpenses);
        assertEquals(mockExpenses.getId(), savedExpenses.getId());
    }

    @Test
    public void givenExpenseId_whenDeleteExpenses_thenExpensesShouldBeRemoved() {
        Long expenseId = 1L;

        doNothing().when(expensesRepository).deleteById(expenseId);

        expensesService.deleteExpenses(expenseId);

        verify(expensesRepository, times(1)).deleteById(expenseId);
    }

    @Test
    public void givenExpenseId_whenGetExpensesById_thenExpensesShouldBeFound() {
        Long expenseId = 1L;
        Expenses mockExpenses = new Expenses();
        mockExpenses.setId(expenseId);

        when(expensesRepository.findById(expenseId)).thenReturn(Optional.of(mockExpenses));

        Optional<Expenses> foundExpenses = expensesService.getExpensesById(expenseId);

        assertTrue(foundExpenses.isPresent());
        assertEquals(mockExpenses.getId(), foundExpenses.get().getId());
    }

    @Test
    public void whenGetAllExpenses_thenListOfAllExpensesShouldBeReturned() {
        Expenses mockExpenses1 = new Expenses();
        mockExpenses1.setId(1L);
        Expenses mockExpenses2 = new Expenses();
        mockExpenses2.setId(2L);

        when(expensesRepository.findAll()).thenReturn(Arrays.asList(mockExpenses1, mockExpenses2));

        List<Expenses> expensesList = expensesService.getAllExpenses();

        assertNotNull(expensesList);
        assertEquals(2, expensesList.size());
    }
}