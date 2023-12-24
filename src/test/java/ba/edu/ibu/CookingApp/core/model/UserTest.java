package ba.edu.ibu.CookingApp.core.model;

import ba.edu.ibu.CookingApp.core.model.enums.UserType;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void shouldAddNewUser(){

        User user = new User();

        user.setId("someId");
        user.setEmail("aminameric@gmail.com");
        user.setPassword("amina123");
        user.setUsername("aminam");
        user.setName("Amina");
        user.setSurname("Meric");
        user.setUserType(UserType.MEMBER);

        Assertions.assertEquals("aminameric@gmail.com", user.getEmail());
        Assertions.assertEquals("aminam", user.getUsername());

    }

    @Test
    void shouldCompareUsers(){

        User user1 = new User();
        User user2 = new User();

        user1.setId("someId");
        user1.setEmail("amila@gmail.com");
        user1.setPassword("12345");
        user1. setUsername("amila12");
        user1.setName("Amila");
        user1.setSurname("Mulahalilovic");
        user1.setUserType(UserType.GUEST);

        user2.setId("someId");
        user2.setEmail("amila@gmail.com");
        user2.setPassword("12345");
        user2. setUsername("amila12");
        user2.setName("Amila");
        user2.setSurname("Mulahalilovic");
        user2.setUserType(UserType.GUEST);

        AssertionsForInterfaceTypes
                .assertThat(user1)
                .usingRecursiveComparison()
                .isEqualTo(user2);
    }

}
