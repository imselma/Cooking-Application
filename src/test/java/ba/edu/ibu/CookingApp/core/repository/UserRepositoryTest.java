package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnAllUsers(){
        List<User> users = userRepository.findAll();

        Assertions.assertEquals("aminameric@gmail.com", users.get(0).getEmail());
        Assertions.assertNotEquals("aminam", users.get(1).getUsername());
    }

    @Test
    public void shouldFindUserByUsername(){
        Optional<User> user = userRepository.findByUsername("tarikm");
        Assertions.assertNotNull(user.orElse(null));
    }

    @Test
    public void shouldFindUserByEmail(){
        Optional<User> newUser = userRepository.findByEmail("aminameric@gmail.com");
        User user = newUser.get();
        Assertions.assertNotEquals("amina", user.getUsername());
    }

}
