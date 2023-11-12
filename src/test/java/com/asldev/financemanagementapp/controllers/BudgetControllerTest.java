package com.asldev.financemanagementapp.controllers;

import com.asldev.financemanagementapp.entities.Budget;
import com.asldev.financemanagementapp.services.BudgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BudgetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BudgetService budgetService;

    private static final String API_URL = "/api/budgets";

    @Test
    void givenBudgets_whenGetAllBudgets_thenReturns200() throws Exception {
        when(this.budgetService.getAllBudgets()).thenReturn(List.of(new Budget()));

        this.mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenBudget_whenGetBudgetById_thenReturns200() throws Exception {
        Budget budget = new Budget();
        // set budget properties here
        when(this.budgetService.getBudgetById(1L)).thenReturn(Optional.of(budget));

        this.mockMvc.perform(get(API_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenBudget_whenCreateBudget_thenReturns200() throws Exception {
        Budget budget = new Budget();
        // set budget properties here
        when(this.budgetService.saveBudget(budget)).thenReturn(budget);

        MvcResult result = this.mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(budget)))
                .andExpect(status().isOk())
                .andReturn();

        // Additional assertions as per need
    }

    @Test
    void givenBudget_whenDeleteBudget_thenReturns200() throws Exception {
        Long id = 1L;
        doNothing().when(this.budgetService).deleteBudget(id);

        this.mockMvc.perform(delete(API_URL + "/1"))
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