package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nisum.model.User;
import org.nisum.repository.UserRepository;
import org.nisum.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    public void testFindByEmail() {
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        Optional<User> resultUser = userService.findByEmail(email);

        assertTrue(resultUser.isPresent());
        assertEquals(email, resultUser.get().getEmail());
    }
}
