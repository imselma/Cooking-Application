package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.UserType;


//When we want to create a new user model instance, but some atributes need to be handeled by DB.
public class UserRequestDTO {
    private String email;
    private String password;
    private String username;
    private UserType userType;
    private String name;
    private String surname;


    public UserRequestDTO() {} //Default constructor providing default values -> it is used when creating a requestDTO.

    //Converting a model to DTO, where the ID is handeled by the DB.
    public UserRequestDTO(User user){

        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.userType = user.getUserType();
        this.name = user.getName();
        this.surname = user.getSurname();

    }

    //Converting a DTO to a model.
    public User toEntity() {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setUserType(userType);
        user.setName(name);
        user.setSurname(surname);

        return user;
    }
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    public UserType getUserType() { return userType;}
    public void setUserType(UserType userType) { this.userType = userType; }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname; }
}
