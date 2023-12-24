package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.repository.IngredientRepository;
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
public class IngredientServiceTest {

    @MockBean
    IngredientRepository ingredientRepository;

    @Autowired
    IngredientService ingredientService;

    @Test
    public void shouldReturnIngredientWhenCreated() {
        Ingredient ingredient = new Ingredient();

        ingredient.setName("Chocolate");
        ingredient.setCategory("Candy");
        ingredient.setMeasurementUnit("g");

        Mockito.when(ingredientRepository.save(ArgumentMatchers.any(Ingredient.class))).thenReturn(ingredient);

        Assertions.assertThat(ingredient.getName()).isEqualTo(ingredient.getName());
        Assertions.assertThat(ingredient.getMeasurementUnit()).isNotNull();
    }

    @Test
    public void shouldReturnIngredientByName(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId("someMongoId");
        ingredient.setName("Chicken");
        ingredient.setCategory("Meat");
        ingredient.setMeasurementUnit("g");

        Mockito.when(ingredientRepository.findByName("Chicken")).thenReturn(Optional.of(ingredient));

        Ingredient foundIngredient = ingredientService.getIngredientByNameNotDTO("Chicken");
        Assertions.assertThat(foundIngredient.getCategory()).isEqualTo("Meat");
    }
}
