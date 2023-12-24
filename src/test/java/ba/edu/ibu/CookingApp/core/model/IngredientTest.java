package ba.edu.ibu.CookingApp.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IngredientTest {

    @Test
    void shouldAddNewIngredient(){

        Ingredient ingredient = new Ingredient();
        ingredient.setId("SomeId");
        ingredient.setCategory("Dairy products");
        ingredient.setName("Milk");
        ingredient.setMeasurementUnit("ml");

        Assertions.assertEquals("SomeId", ingredient.getId());
        Assertions.assertEquals("Dairy products", ingredient.getCategory());
        Assertions.assertEquals("Milk", ingredient.getName());
        Assertions.assertEquals("ml", ingredient.getMeasurementUnit());
    }

    @Test
    void shouldCompareIngredients(){

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId("SomeId");
        ingredient1.setCategory("Food suplements");
        ingredient1.setName("Oil");
        ingredient1.setMeasurementUnit("ml");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId("SomeId");
        ingredient2.setCategory("Food suplements");
        ingredient2.setName("Oil");
        ingredient2.setMeasurementUnit("ml");

        AssertionsForInterfaceTypes
                .assertThat(ingredient1)
                .usingRecursiveComparison()
                .isEqualTo(ingredient2);
    }

}
