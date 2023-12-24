package ba.edu.ibu.CookingApp.core.model;

import ba.edu.ibu.CookingApp.core.model.enums.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReviewTest {

    @Test
    void shouldAddNewReview(){

        Recipe recipe = new Recipe();
        recipe.setId("someId");
        recipe.setName("Pancake");
        recipe.setSteps("1. Add 3 eggs, flour anf milk. 2. Mix it together. 3. Bake pancakes on a pan.");
        recipe.setDescription("Thin, flat, circular piece of cooked batter made from milk, flour, and eggs. ");
        recipe.setCookingTime(30.00);

        User user = new User();
        user.setId("someId");
        user.setEmail("aminameric@gmail.com");
        user.setPassword("amina123");
        user.setUsername("aminam");
        user.setName("Amina");
        user.setSurname("Meric");
        user.setUserType(UserType.MEMBER);

        Review review = new Review();
        review.setComment("The recipe is excellent.");
        review.setId("SomeId");
        review.setRecipe(recipe);
        review.setUser(user);

        Assertions.assertEquals("The recipe is excellent.",  review.getComment());
        Assertions.assertEquals("SomeId", review.getId());
        Assertions.assertEquals(recipe, review.getRecipe());
        Assertions.assertEquals(user, review.getUser());
    }

}
