package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.model.User;
import app.repository.UserRepository;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User(1, "testuser", "test@example.com");
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(testUser, new User(2, "user2", "user2@example.com"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testAddUser() {
        when(userRepository.save(testUser)).thenReturn(testUser);

        User result = userService.addUser(testUser);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    public void testGetUserByUsername() {
        when(userRepository.findByUsername("testuser")).thenReturn(testUser);

        User result = userService.getUserByUsername("testuser");

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(userRepository, times(1)).findByUsername("testuser");
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findByUserId(1)).thenReturn(testUser);

        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        verify(userRepository, times(1)).findByUserId(1);
    }
}
