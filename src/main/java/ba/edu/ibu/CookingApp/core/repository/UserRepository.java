package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

    List<User> findAll();
    Optional<User> findById(String id);
    Optional<User> findByNameAndSurname(String name, String surname);
    User save(UserRequestDTO userData);

}


//Exceptions are saved in core package
//pull request -> be on diferent branche (from intelij or terminal)  - > do work that you want -> if done ->add . -> commit -> push. When visitin Github -> click on pull request -> add commnets -> in reviewers part assign aldin and becir and than -> create pull request
