package com.asldev.financemanagementapp.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    public static final Long ID = 1L;
    public static final String USERNAME = "Test";
    public static final String PASSWORD = "Password";
    public static final String EMAIL = "test@test.com";

    @Test
    public void givenUser_whenSettingValues_thenCorrectValuesReturned() {
        User user = new User();
        user.setId(ID);
        user.setUserName(USERNAME);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);

        assertEquals(ID, user.getId());
        assertEquals(USERNAME, user.getUserName());
        assertEquals(PASSWORD, user.getPassword());
        assertEquals(EMAIL, user.getEmail());
    }
}
