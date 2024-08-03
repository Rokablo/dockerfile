package com.example.myapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    // Código de las pruebas unitarias



@InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.getUserById(1L);
        Assertions.assertNotNull(found);
        Assertions.assertEquals(user.getId(), found.getId());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("Test User");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User created = userService.createUser(user);
        Assertions.assertNotNull(created);
        Assertions.assertEquals(user.getName(), created.getName());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Updated Name");
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User updated = userService.updateUser(1L, user);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals(user.getName(), updated.getName());
    }

    @Test
    public void testUpdateUser_NotFound() {
        User user = new User();
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User updated = userService.updateUser(1L, user);
        Assertions.assertNull(updated);
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId(1L);
        Mockito.doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1L);
    }
}
