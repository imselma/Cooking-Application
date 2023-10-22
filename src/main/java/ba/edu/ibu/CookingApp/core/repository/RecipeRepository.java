package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository  extends MongoRepository<Recipe, String> {

    List<Recipe> findAll();
    Optional<Recipe> findById(String id);
    Optional<Recipe> findByName(String name);
    Recipe save(RecipeRequestDTO recipeData);

}
