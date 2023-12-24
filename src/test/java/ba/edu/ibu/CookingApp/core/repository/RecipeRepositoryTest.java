package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void shouldReturnAllBooks() {
        List<Recipe> recipeList = recipeRepository.findAll();

        Assertions.assertEquals(3, recipeList.size());
        Assertions.assertEquals("Pizza", recipeList.get(0).getName());

    }

    @Test
    public void shouldFindRecipeByName() {
        Optional<Recipe> recipe = recipeRepository.findByName("Pancakes");
        Recipe newRecipe = recipe.get();

        Assertions.assertNotEquals("Some description", newRecipe.getDescription());
    }

}
