package ba.edu.ibu.CookingApp.core.repository;

import ba.edu.ibu.CookingApp.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

    @Query(value="{$or:[{email:'?0'}, {username:'?0'}]}")
    Optional<User> findByUsername(String username);
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);



}

