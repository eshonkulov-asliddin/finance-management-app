package com.asldev.financemanagementapp.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    public static final Long ID = 1L;
    public static final String USERNAME = "Test";
    public static final String PASSWORD = "Password";
    public static final String EMAIL = "test@test.com";

    @Test
     void givenUser_whenSettingValues_thenCorrectValuesReturned() {
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

    @Test
    void testHashcodeAndEqualsMethods() {
        User user1 = new User();
        user1.setId(ID);
        user1.setUserName(USERNAME);
        user1.setPassword(PASSWORD);
        user1.setEmail(EMAIL);

        User user2 = new User();
        user2.setId(ID);
        user2.setUserName(USERNAME);
        user2.setPassword(PASSWORD);
        user2.setEmail(EMAIL);

        assertEquals(user1.hashCode(), user2.hashCode());
        assertEquals(user1, user2);
    }

}
