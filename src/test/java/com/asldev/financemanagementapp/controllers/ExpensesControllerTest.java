package com.asldev.financemanagementapp.controllers;

import com.asldev.financemanagementapp.entities.Expenses;
import com.asldev.financemanagementapp.services.ExpensesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExpensesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpensesService expensesService;

    private static final String API_URL = "/api/expenses";

    @Test
    void givenExpenses_whenGetAllExpenses_thenReturns200() throws Exception {
        // Given
        when(expensesService.getAllExpenses()).thenReturn(List.of(new Expenses()));

        // When & Then
        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenExpense_whenGetExpensesById_thenReturns200() throws Exception {
        // Given
        Expenses expenses = new Expenses();
        // set expenses properties here
        when(expensesService.getExpensesById(1L)).thenReturn(Optional.of(expenses));

        // When & Then
        mockMvc.perform(get(API_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenExpenses_whenCreateExpenses_thenReturns200() throws Exception {
        // Given
        Expenses expenses = new Expenses();
        // set expenses properties here
        when(expensesService.saveExpenses(expenses)).thenReturn(expenses);

        // When & Then
        mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(expenses)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenExpenseId_whenDeleteExpenses_thenReturns200() throws Exception {
        // Given
        Long id = 1L;
        doNothing().when(expensesService).deleteExpenses(id);

        // When & Then
        mockMvc.perform(delete(API_URL + "/1"))
                .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}