package com.asldev.financemanagementapp.controllers;

import com.asldev.financemanagementapp.entities.User;
import com.asldev.financemanagementapp.services.UserService;
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
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private static final String API_URL = "/api/users";

    @Test
    void givenUsers_whenGetAllUsers_thenReturns200() throws Exception {
        // Given
        when(userService.getAllUsers()).thenReturn(List.of(new User()));

        // When & Then
        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenUser_whenGetUserById_thenReturns200() throws Exception {
        // Given
        User user = new User();
        // set user properties here
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        // When & Then
        mockMvc.perform(get(API_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenUser_whenCreateUser_thenReturns200() throws Exception {
        // Given
        User user = new User();
        // set user properties here
        when(userService.saveUser(user)).thenReturn(user);

        // When & Then
        MvcResult result = mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andExpect(status().isOk())
                .andReturn();

        // Additional assertions as per need
    }

    @Test
    void givenUser_whenDeleteUser_thenReturns200() throws Exception {
        // Given
        Long id = 1L;
        doNothing().when(userService).deleteUser(id);

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