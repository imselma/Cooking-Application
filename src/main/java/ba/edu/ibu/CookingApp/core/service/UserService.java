package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.api.mailsender.MailSender;
import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.UserRepository;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private MailSender mailgunSender;
    @Autowired
    private MailSender sendgridSender;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } //Constructor

    public String sendEmailToAllUsers(String message) {
        List<User> users = userRepository.findAll();
        return mailgunSender.send(users, message);

        //return mailgunSender.send(users,message);
    }


    //Gets all users
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDTO::new)
                .collect(toList());
    }

    //Gets users by id
    public UserDTO getUserById (String id){
        Optional<User> user = userRepository.findById(id); //Retrieving the instance with specific Id
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return new UserDTO(user.get()); // Bur you are returning only the data that can be shown, defined by the userDTO
    }

    //Get users by full name
    public UserDTO getUserByFullName (String name, String surname){
        Optional<User> user = userRepository.findByNameAndSurname(name, surname); //Optional, because there may not pe a sepcified user.
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return new UserDTO(user.get());
    }

    //Add new user
    public UserDTO addUser (UserRequestDTO userData){
        User newUser = userRepository.save(userData.toEntity());  //Proceeding only the data that is defined by the DTO, and that's why I am using the .toEntity() to convert it to the actual entity + password data.

        return new UserDTO(newUser);
    }

    //Update the user
    public UserDTO updateUser(String id, UserRequestDTO userData) {

        /*Prosljedjujem, id usera koji zelim ispraviti i podatke koje zelim ispraviti. Prvo nadjem tog usera preko id,
          zatim pravim "kopiju" u kojoj spremam promjene, a zatim toj kopiji dodjeljujem id originala i spremam sve.
          Zasto nisam mogla odmah user.save()?*/

        Optional<User> user = userRepository.findById(id);  //finding the user by ID
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        User updatedUser = userData.toEntity(); //converting userData from  userDTO model to actual entity.
        updatedUser.setId(user.get().getId()); //sets the updated user to match the user retrieved from the db, in that way I am just updating an existing retrieved user, rather than creating a new.
        updatedUser = userRepository.save(updatedUser); //saving the changes
        return new UserDTO(updatedUser); //Returning beck to USERdto object
    }

    //Delete the user
    public void deleteUser (String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        user.ifPresent(userRepository::delete);
    }
}
