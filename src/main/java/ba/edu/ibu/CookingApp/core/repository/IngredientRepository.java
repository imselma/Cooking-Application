package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    Optional<Ingredient> findByName(String name);
    Optional<Ingredient> findById(String id);
}
