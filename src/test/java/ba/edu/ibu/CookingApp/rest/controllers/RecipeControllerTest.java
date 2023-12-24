package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.service.JwtService;
import ba.edu.ibu.CookingApp.core.service.RecipeService;
import ba.edu.ibu.CookingApp.core.service.UserService;
import ba.edu.ibu.CookingApp.rest.configuration.SecurityConfiguration;
import ba.edu.ibu.CookingApp.rest.dto.RecipeDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@AutoConfigureMockMvc
@WebMvcTest(RecipeController.class)
@Import(SecurityConfiguration.class)
public class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    RecipeService recipeService;
    @MockBean
    User user;
    @MockBean
    JwtService jwtService;
    @MockBean
    UserService userService;
    @MockBean
    AuthenticationProvider authenticationProvider;
    @Test
    void shouldReturnAllBooks() throws Exception{

        User user = new User();
        user.setName("Amina");
        Recipe recipe = new Recipe();
        RecipeDTO recipeDTO = new RecipeDTO(recipe);
        recipe.setName("Pizza");
        recipe.setDescription("Pizza is an Italian food made with different toppings.");
        recipe.setCookingTime(20.00);
        recipe.setSteps("1. Make a dough. 2. Proof the dough. 3. Prepare toppings. 5. Shape the dough and add toppings. 6. Bake the pizza.");
        recipe.setUser(user);

        Mockito.when(recipeService.getRecipes()).thenReturn(List.of(recipeDTO));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("api/recipes").contentType(MediaType.APPLICATION_JSON)).andReturn();
        String response = result.getResponse().getContentAsString();
        System.out.println(response);

    }

}
