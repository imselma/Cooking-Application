package ba.edu.ibu.CookingApp.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    @Test
    void shouldAddNewRecipe(){

        Recipe recipe = new Recipe();
        recipe.setId("someId");
        recipe.setName("Pancake");
        recipe.setSteps("1. Add 3 eggs, flour anf milk. 2. Mix it together. 3. Bake pancakes on a pan.");
        recipe.setDescription("Thin, flat, circular piece of cooked batter made from milk, flour, and eggs. ");
        recipe.setCookingTime(30.00);

        Assertions.assertEquals("Pizza", recipe.getName());
        Assertions.assertEquals(20.00, recipe.getCookingTime());
    }

    @Test
    void shouldCompareRecipes(){

        Recipe recipe1 = new Recipe();
        recipe1.setId("someId");
        recipe1.setName("Pizza");
        recipe1.setSteps("1. Make a dough. 2. Proof the dough. 3. Prepare toppings. 5. Shape the dough and add toppings. 6. Bake the pizza.");
        recipe1.setDescription("Pizza is an Italian food made with different toppings.");
        recipe1.setCookingTime(20.00);

        Recipe recipe2 = new Recipe();
        recipe2.setId("someId");
        recipe2.setName("Pizza");
        recipe2.setSteps("1. Make a dough. 2. Proof the dough. 3. Prepare toppings. 5. Shape the dough and add toppings. 6. Bake the pizza.");
        recipe2.setDescription("Pizza is an Italian food made with different toppings.");
        recipe2.setCookingTime(20.00);

        AssertionsForInterfaceTypes
                .assertThat(recipe1)
                .usingRecursiveComparison()
                .isEqualTo(recipe2);
    }
}
