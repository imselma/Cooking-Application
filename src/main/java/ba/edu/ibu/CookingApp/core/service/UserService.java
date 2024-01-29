package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.UserRepository;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserRequestDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Add new user / Register a user
    public UserDTO addUser (UserRequestDTO userData){
        User newUser = userRepository.save(userData.toEntity());

        return new UserDTO(newUser);
    }

    //Gets users by id / show user's profile
    public UserDTO getUserById (String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return new UserDTO(user.get());
    }

    //Get user by username or email
    public UserDTO getUserByUsername (String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        return new UserDTO(user.get());
    }

    //Get users by name
    public User getUserByName (String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return user.get();
    }

    //Get by email
    public User getUserByEmail (String email){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return user.get();
    }


    //Gets all users
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDTO::new)
                .collect(toList());
    }
    //Update the user's profile (included the changing of the password)
    public UserDTO updateUser(String id, UserRequestDTO userData) {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        User updatedUser = userData.toEntity(); //converting userData from  userDTO model to actual entity.
        updatedUser.setId(user.get().getId()); //sets the updated user to match the user retrieved from the db, in that way I am just updating an existing retrieved user, rather than creating a new.
        updatedUser = userRepository.save(updatedUser); //saving the changes
        return new UserDTO(updatedUser); //Returning beck to userDTO object
    }

    //Delete the user
    public void deleteUser (String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        user.ifPresent(userRepository::delete);
    }

    //Get user by Id but as a User model, not UserDTO
    public User getUserByIdNoDTO (String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        System.out.println(user.get());

        return user.get();
    }

    //Get user by name but as a User model, not UserDTO
    public User getUserByNameNotDTO (String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        return user.get();
    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found."));
            }
        };
    }

}
