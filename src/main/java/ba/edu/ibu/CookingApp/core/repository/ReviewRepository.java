package ba.edu.ibu.CookingApp.core.repository;
import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Review;
import ba.edu.ibu.CookingApp.rest.dto.ReviewRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findAll();
    Optional<Review> findById(String id);
}
