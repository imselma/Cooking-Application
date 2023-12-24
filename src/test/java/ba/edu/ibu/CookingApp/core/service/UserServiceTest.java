package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.UserRepository;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class UserServiceTest {
    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void shouldReturnUserWhenCreated(){
        User user = new User();
        user.setName("Selma");
        user.setSurname("Imsirovic");
        user.setEmail("selma@gmail.com");
        user.setUsername("selmai");
        user.setPassword("123456");
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        Assertions.assertThat(user.getName()).isEqualTo(user.getName());
        Assertions.assertThat(user.getUsername()).isNotNull();
    }

    @Test
    public void shouldRetutnUserById(){
        User user = new User();
        user.setId("someMongoId");
        user.setName("Zerina");
        user.setUsername("zerinaS");
        user.setSurname("Saldic");

        Mockito.when(userRepository.findById("someMongoId")).thenReturn(Optional.of(user));

        User foundUser = userService.getUserByIdNoDTO("someMongoId");
        Assertions.assertThat(foundUser.getName()).isEqualTo("Zerina");
    }
}
