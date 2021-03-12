package ch.noser.uek223.user.unittest;

import ch.noser.uek223.domain.user.User;
import ch.noser.uek223.domain.user.UserRepository;
import ch.noser.uek223.domain.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceImplUnitTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private UserRepository userRepository;


    @Test
    public void create_HappyPath_True(){
        User user = new User(UUID.randomUUID(), "severin.baur@bluewin.ch", "Severin", "Baur", "pwd", null, null, null);
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        Mockito.when(userRepository.saveAndFlush(user)).thenReturn(user);
        User result = userService.create(user);
        Assertions.assertEquals(user.getEmail(), result.getEmail());
    }

    @Test
    public void create_ExistingEmail_RuntimeExceptionThrown(){
        User user = new User(UUID.randomUUID(), "severin.baur@bluewin.ch", "Severin", "Baur", "pwd", null, null, null);
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));
    }
}
