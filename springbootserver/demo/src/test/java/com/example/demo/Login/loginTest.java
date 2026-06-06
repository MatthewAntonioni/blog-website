package com.example.demo.Login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class loginTest {

@Test
    public void testLogin() {
        // Create a fake UserRepo
        UserRepo mockRepo = mock(UserRepo.class);

        // Create a fake user to return
        User fakeUser = new User();
        fakeUser.setUsername("admin");
        fakeUser.setPassword("password123");

        // When searching for "admin" return our fake user
        when(mockRepo.findByUsername("admin")).thenReturn(fakeUser);
        // When searching for anything else return null
        when(mockRepo.findByUsername("user")).thenReturn(null);

        // Create AuthController with the mock
        AuthController controller = new AuthController(mockRepo);

        assertTrue(controller.authenticate("admin", "password123"));
        assertFalse(controller.authenticate("user", "password123"));
        assertFalse(controller.authenticate("admin", "wrongpassword"));
        assertFalse(controller.authenticate("", ""));

        when(mockRepo.findByUsername("admin")).thenReturn(fakeUser);

        fakeUser.setAdmin(true);

        assertTrue(controller.authenticate("admin", "password123") && fakeUser.isAdmin());
    }
    
}
