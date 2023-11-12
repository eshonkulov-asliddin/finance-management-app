package com.asldev.financemanagementapp.services;

import com.asldev.financemanagementapp.entities.User;
import com.asldev.financemanagementapp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void givenUser_whenSaveUser_thenUserShouldBeStored() {
        User mockUser = new User();
        mockUser.setId(1L);

        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        User savedUser = userService.saveUser(mockUser);

        assertNotNull(savedUser);
        assertEquals(mockUser.getId(), savedUser.getId());
    }

    @Test
    void givenUserId_whenDeleteUser_thenUserShouldBeRemoved() {
        Long userId = 1L;

        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void givenUserId_whenGetUserById_thenUserShouldBeFound() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        Optional<User> foundUser = userService.getUserById(userId);

        assertTrue(foundUser.isPresent());
        assertEquals(mockUser.getId(), foundUser.get().getId());
    }

    @Test
    void whenGetAllUsers_thenListOfAllUsersShouldBeReturned() {
        User mockUser1 = new User();
        mockUser1.setId(1L);
        User mockUser2 = new User();
        mockUser2.setId(2L);

        when(userRepository.findAll()).thenReturn(Arrays.asList(mockUser1, mockUser2));

        List<User> userList = userService.getAllUsers();

        assertNotNull(userList);
        assertEquals(2, userList.size());
    }
}