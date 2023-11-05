package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.Tip;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import ba.edu.ibu.CookingApp.rest.dto.TipRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipRepository extends MongoRepository<Tip, String> {

    List<Tip> findAll();
    Optional<Tip> findById(String id);
    Optional<Tip> findByName(String name);
    Tip save(TipRequestDTO tipData);
}
