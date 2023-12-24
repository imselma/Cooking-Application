package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Test
    public void shouldReturnAllIngredients() {

        List<Ingredient> ingredientList = ingredientRepository.findAll();

        Assertions.assertEquals(9, ingredientList.size());
        Assertions.assertEquals("Suggar", ingredientList.get(2).getName());
    }

    @Test
    public void shouldFindIngredientByName() {
        Optional<Ingredient> ingredient = ingredientRepository.findByName("Flour");
        Ingredient newIngredient = ingredient.get();

        Assertions.assertEquals("Food suplement", newIngredient.getCategory());
        Assertions.assertNotEquals("ml", newIngredient.getMeasurementUnit());
    }
}
