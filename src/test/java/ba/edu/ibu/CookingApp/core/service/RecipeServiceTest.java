package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;
import ba.edu.ibu.CookingApp.core.repository.RecipeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class RecipeServiceTest {

    @MockBean
    RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    @Test
    public void shouldReturnRecipeWhenCreated() {
        Recipe recipe = new Recipe();

        User user = new User();
        user.setName("Selma");


       /* Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Flour");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Sugar");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Milk");*/
        List<String> ingredientList = new ArrayList<>();
        /*ingredientList.add(ingredient1);
        ingredientList.add(ingredient2);
        ingredientList.add(ingredient3);*/
        ingredientList.add("Milk");
        ingredientList.add("Flour");
        ingredientList.add("Suggar");

        /*List<String> ingredientsNameList = new ArrayList<>();
        ingredientList.forEach(ingredient ->
                ingredientsNameList.add(ingredient.getName() != null ? ingredient.getName() : "")
        );*/

        recipe.setName("Muffins");
        recipe.setDescription("Muffins are small, flavorful cakes with various additions like chocolate or fruit. They're quick to make and perfect for breakfast or a snack.");
        recipe.setCookingTime(45.00);
        recipe.setUser(user);
        recipe.setRestriction(RecipeRestriction.LACTOSE_FREE);
        recipe.setSteps("1. Mix ingredients. 2.Bake muffins");
        recipe.setIngredients(ingredientList);

        Mockito.when(recipeRepository.save(ArgumentMatchers.any(Recipe.class))).thenReturn(recipe);

        Assertions.assertThat(recipe.getName()).isEqualTo(recipe.getName());
        Assertions.assertThat(recipe.getDescription()).isNotNull();
    }

    @Test
    public void shouldRetutnUserById(){
        Recipe recipe = new Recipe();

        User user = new User();
        user.setName("Selma");


      /*  Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Flour");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Sugar");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Milk");*/
        List<String> ingredientList = new ArrayList<>();
       /* ingredientList.add(ingredient1);
        ingredientList.add(ingredient2);
        ingredientList.add(ingredient3);*/
        ingredientList.add("Flour");
        ingredientList.add("Sugar");
        ingredientList.add("Milk");

       /* List<String> ingredientsNameList = new ArrayList<>();
        ingredientList.forEach(ingredient ->
                ingredientsNameList.add(ingredient.getName() != null ? ingredient.getName() : "")
        );*/

        recipe.setId("someMongoId");
        recipe.setName("Muffins");
        recipe.setDescription("Muffins are small, flavorful cakes with various additions like chocolate or fruit. They're quick to make and perfect for breakfast or a snack.");
        recipe.setCookingTime(45.00);
        recipe.setUser(user);
        recipe.setRestriction(RecipeRestriction.LACTOSE_FREE);
        recipe.setSteps("1. Mix ingredients. 2.Bake muffins");
        recipe.setIngredients(ingredientList);

        Mockito.when(recipeRepository.findById("someMongoId")).thenReturn(Optional.of(recipe));


        Recipe foundRecipe = recipeService.getRecipeByIdNoDTO("someMongoId");
        Assertions.assertThat(foundRecipe.getName()).isEqualTo("Muffins");
    }
}
